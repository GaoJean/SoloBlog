package com.gao.soloblog.framework.verify;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gao.soloblog.common.constant.Constant.SESSION_AND_COOKIE;
import com.gao.soloblog.common.constant.SystemEnum;
import com.gao.soloblog.common.entity.AppServerModel;
import com.gao.soloblog.common.exception.ReLoginException;
import com.gao.soloblog.common.exception.TokenException;
import com.gao.soloblog.common.model.ResultModel;
import com.gao.soloblog.common.model.ResultModelMetadata;
import com.gao.soloblog.common.util.logger.Logger;
import com.gao.soloblog.common.util.logger.LoggerFactory;

/**
 * 入口切面
 * 
 */
@Component
@Aspect
public class VerificationAspect {
    private static final Logger logger = LoggerFactory.getLogger(VerificationAspect.class);
    private static final String TOKEN_METHOD = "getToken";

    /**
     * 所有请求都加入此切面
     */
    @Pointcut("execution(public * com.gao.soloblog.web.controller..*.*(..))")
    public void pointcut() {
    }

    /**
     * 主验证方法
     * 
     * @see 验证 token
     */
    @Around("pointcut()")
    public Object verify(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        Object[] params = proceedingJoinPoint.getArgs();

        if (!this.proxyRequired(method)) {
            //不需要代理此请求
            ResultModel resultModel = new ResultModel();
            resultModel = (ResultModel) proceedingJoinPoint.proceed();

            //如果没有抛出任何异常 认为请求成功 设置请求状态为200
            resultModel.setCode(SystemEnum.success_200.getIndex());
            resultModel.setDescription(SystemEnum.success_200.getValue());
            resultModel.setMetadata(ResultModelMetadata.parse(resultModel.getModel()));
            return resultModel;
        } else {
            //需要代理此请求
            ResultModel resultModel = new ResultModel();
            try {
                //验证token
                if (AppServerModel.verifyToken && this.tokenVerifyRequired(method)) {
                    if (!this.verifyToken(method, params)) {
                        //token验证失败
                        throw new TokenException();
                    }
                }
                //执行业务流 所有返回值用 ResultModel类型
                resultModel = (ResultModel) proceedingJoinPoint.proceed();

                //如果没有抛出任何异常 认为请求成功 设置请求状态为200
                resultModel.setCode(SystemEnum.success_200.getIndex());
                resultModel.setDescription(SystemEnum.success_200.getValue());
            } catch (TokenException e) {
                // token 验证失败
                logger.debug("Token验证失败");
                resultModel.setCode(SystemEnum.token_expire.getIndex());
                resultModel.setDescription(SystemEnum.token_expire.getValue());
            }catch (ReLoginException e) {
                // 认证失败/Session失效
                if(e.getMessage() != null) {
                    // 认证失败
                    logger.warn("认证失败Method - " + method.getName());
                }
                resultModel.setCode(SystemEnum.re_login.getIndex());
                resultModel.setDescription(SystemEnum.re_login.getValue());
            } catch (Throwable e) {
                // 异常
                logger.error("异常捕获Method - " + method.getName(), e);
                resultModel.setCode(SystemEnum.server_exception.getIndex());
                resultModel.setDescription(SystemEnum.server_exception.getValue());
            } finally {
                resultModel.setMetadata(ResultModelMetadata.parse(resultModel.getModel()));
            }
            return resultModel;
        }
    }

    /**
     * 判断请求是否需要被代理 如果不需要直接执行返回 否则进行验证的流程
     */
    private boolean proxyRequired(Method method) throws ClassNotFoundException {
        return AnnotationUtil.containsAnnotation(method, Verification.class);
    }

    /**
     * 当前请求是否需要验证token
     */
    private boolean tokenVerifyRequired(Method method) throws ClassNotFoundException {
        Verification verificationAnnotation = AnnotationUtil
                .getAnnotationWithType(method, Verification.class);
        if (verificationAnnotation != null && verificationAnnotation.token() == true) {
            // 当有这个注解 而且token == true时 验证token
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证token
     * @throws ReLoginException 如果Session失效了 返回重新登陆错误码
     */
    private boolean verifyToken(Method method, Object[] params) throws Exception {
        try {
            String token = this.reflectToken(method, params);
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            String tokenCache = (String)session.getAttribute(
                    SESSION_AND_COOKIE.SESSION_TOKEN);
            if (token == null) {
                // 取不到Session 认为Session失效 要求重新登陆
                throw new ReLoginException();
            }
            return token.equals(tokenCache);
        } catch (Exception e) {
            throw new ReLoginException();
        }
    }

    /**
     * 带有 @Verification / @ReqeustBody 注解 则此实参一定含有 getToken 方法 反射得到 token
     */
    private String reflectToken(Method method, Object[] params) throws Exception {
        String token = null;
        Object requestBodyParam = AnnotationUtil.getActualParameterWithAnnotation(method, RequestBody.class, params);
        if (requestBodyParam != null) {
            Method tokenMethod = requestBodyParam.getClass().getMethod(TOKEN_METHOD);
            token = (String) tokenMethod.invoke(requestBodyParam);
        }
        return token;
    }
}
