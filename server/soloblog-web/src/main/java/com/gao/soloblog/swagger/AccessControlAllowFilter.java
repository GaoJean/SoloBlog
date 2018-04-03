package com.gao.soloblog.swagger;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.gao.soloblog.common.util.logger.Logger;
import com.gao.soloblog.common.util.logger.LoggerFactory;



/**
* @ClassName: AccessControlAllowFilter
* @Description: 用于跨域上传文件请求处理的filter
* @author Sylar chensiyu@danlu.com
* @date 2017年3月22日
*
*/
public class AccessControlAllowFilter extends OncePerRequestFilter {
	
	private Logger logger = LoggerFactory.getLogger(AccessControlAllowFilter.class);
	@Override
	protected void doFilterInternal(final HttpServletRequest request,
			final HttpServletResponse response, final FilterChain filterChain)
			throws ServletException, IOException {
		String method = request.getMethod();
		if ("OPTIONS".equals(method)) {
			logger.info("进入跨域请求处理");
			response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Cache-Control,X-Requested-With,Content-Type");
            logger.info("跨域请求处理完毕");	
			return;
		}else {
			response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Cache-Control,X-Requested-With,Content-Type");
		}
		filterChain.doFilter(request, response);
	}
}
