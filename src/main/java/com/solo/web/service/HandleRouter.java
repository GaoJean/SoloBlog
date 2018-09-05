package com.solo.web.service;

import com.solo.common.exception.BusinessException;
import com.solo.common.exception.BussinessErrorCodeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author gaojian
 * @Date 2018/8/24
 */
public class HandleRouter {

    private List<HandleRouterRule> rules = new ArrayList<>();

    /**
     * 开始一个新的订单处理路由规则
     *
     * @return
     */
    public HandleRouterRule rule() {
        return new HandleRouterRule(this);
    }

    /**
     * 过滤路由订单规则【创建】
     *
     * @param request
     * @return
     */
    public String login(String request ,Integer type) throws BusinessException {
        String response = null;
        final List<HandleRouterRule> matchedRules = new ArrayList<>();
        // 规则匹配
        for (final HandleRouterRule rule : rules) {
           if (rule.match(type)) {
                matchedRules.add(rule);
                if (!rule.isReEnter()) {
                    break;
                }
            }
        }
        if (matchedRules.isEmpty()) {
            throw new BusinessException(BussinessErrorCodeEnum.BIZ_ERROR);
        }
        for (HandleRouterRule rule : matchedRules) {
            response = rule.login(request);
        }
        return response;
    }



    public List<HandleRouterRule> getRules() {
        return rules;
    }
}
