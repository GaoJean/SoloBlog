package com.solo.web.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author gaojian
 * @Date 2018/8/24
 */
public class HandleRouterRule {

    private final HandleRouter router;

    private boolean reEnter = false;

    private Integer type ;

    private List<BaseHandle> handles = new ArrayList<>();

    public HandleRouterRule (HandleRouter router){
        this.router = router;
    }

    public boolean isReEnter() {
        return reEnter;
    }

    /**
     * 添加订单处理handler
     *
     * @param handler
     * @return
     */
    public HandleRouterRule handler(BaseHandle handler) {
        return handler(handler, (BaseHandle[]) null);
    }

    /**
     * 设置订单类型
     *
     * @param orderType
     * @return
     */
    public HandleRouterRule type(Integer orderType) {
        this.type = orderType;
        return this;
    }
    /**
     * 【所有】规则结束，代表如果一个消息匹配该规则，那么它将不再会进入其他规则
     *
     * @return
     */
    public HandleRouter end() {
        this.router.getRules().add(this);
        return this.router;
    }

    /**
     * 【本】规则结束，但是消息还会进入其他规则
     *
     * @return
     */
    public HandleRouter next() {
        this.reEnter = true;
        return end();
    }

//    /**
//     * 判断规则是否匹配
//     *
//     * @param request
//     * @return
//     */
//    protected boolean match(OrderRequestDO request) {
//        if (this.orderType == null) {
//            return true;
//        }
//        if (request.getOrderType() == null) {
//            return false;
//        } else if (request.getOrderType().getCode() == this.orderType.getCode()) {
//            return true;
//        }
//        return false;
//    }

    /**
     * 添加多个订单处理handler
     *
     * @param handler
     * @param others
     * @return
     */
    public HandleRouterRule handler(BaseHandle handler, BaseHandle... others) {
        this.handles.add(handler);
        if (others != null && others.length > 0) {
            for (BaseHandle h : others) {
                this.handles.add(h);
            }
        }
        return this;
    }


    public String login(String name){
        String result = "";
        for (BaseHandle handle : handles){
            if (handle == null) {
                continue;
            }
            result = handle.login(name);
        }
        return result;
    }

    public List<BaseHandle> getHandles() {
        return handles;
    }

    public void setHandles(List<BaseHandle> handles) {
        this.handles = handles;
    }

    protected boolean match(Integer type) {
        if (this.type == null) {
            return true;
        }
        if (type == null) {
            return false;
        } else if (type == this.type) {
            return true;
        }
        return false;
    }
}
