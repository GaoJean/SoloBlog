package com.solo.common.constant;

/**
 * 系统常量
 */
public interface SystemConstant {

    
    /** 默认当前页码 **/
    public static final int    PAGE_CURRENT       = 1;
    /** 分页每页显示的记录数 **/
    public static final int    PAGE_SIZE          = 100;
    /** 用户类型终端店 **/
    public static final String USER_TYPE_T        = "01";
    /** 用户类型经销商 **/
    public static final String USER_TYPE_B        = "02";
    /** 终端店 **/
    public static final String TERMINAL           = "terminal";
    /** 配送商*/
    public static final String BUSINESS           = "business";

 	/** 站点标识 **/
 	public static final String WEBSITE_URL = "www.danlu.com";

 	/** 常量 用于判断业务员权限用*/
    public static final String USER_TYPE_SALESMAN = "销售业务管理";
    
    /** 常量 用于判断系统管理员权限用*/
    public static final String ACL_MANAGER = "系统管理员";
    
    /** 常量 用于判断业务分配权限用*/
    public static final String ACL_ASSIGNED = "业务员管理";
    
    /** 常量 用于判断财务管理权限*/
    public static final String ACL_TREASURER_MANAGER = "财务管理";
    
    /** 常量 用于判断配送管理权限用*/
    public static final String ACL_DISTRIBUTION_MANAGER = "配送管理";
    
    /** 常量 用于判断客户管理权限用*/
    public static final String ACL_CUSTOMER_MANAGER = "客户管理";
    
    /******权限ID*****/
    /**
     * 权限 终端店
     */
    public static final String PRIVILEGE_TERMINAL_V2 = "6c31be02b168434c930b1fbde94a84ba";
    
    
    /**
     * 权限 系统管理员
     */
    public static final String PRIVILEGE_ADMIN_V2 = "e1cea524042d4d168158378a50e2d132";
    
    /**
     * 权限 销售业务管理
     */
    public static final String PRIVILEGE_SALE_V2 = "5b92bb1d38e54d3ba9f14d625193953a";  
    
    /**
     * 权限 销售业务管理(发货)
     */
    public static final String PRIVILEGE_SEND_V2 = "a134eaa03dac496c8a869c48aaea6005";  
    
    /**
     * 权限 销售业务管理（拆单）
     */
    public static final String PRIVILEGE_SPLIT_V2 = "148fc2c26251487791cbbd0cc5a3a857";  
       
    /**
     * 权限 销售业务管理（改价）
     */
    public static final String PRIVILEGE_CP_V2 = "3556286008a24dd6b9a1fa33faadb296"; 
    
    /**
     * 权限 业务员管理
     */
    public static final String PRIVILEGE_DEPART_V2 = "c7f982a72f22443b976099f5b3eca517";   
    
    /**
     * 权限 采购下单
     */
    public static final String PRIVILEGE_ORDER_V2 = "6b0f18b5231a43b6a4c4166b20ecf32d";
    
    /**
     * 权限 采购支付
     */
    public static final String PRIVILEGE_PAY_V2 = "6f9109ea9d854faa98cae84b2c3b3c10";   
    
    /**
     * 权限 财务管理
     */
    public static final String PRIVILEGE_FINANCE_V2 = "511ee5e46b144522abec83773d6aadcd";  
    
    /**
     * 权限 员工权限
     */
    public static final String PRIVILEGE_STAFF_V2 = "0dc567bbe45143cfa4caa3d7610a9039";
    
    /**
     * 权限 省运营
     */
    public static final String PRIVILEGE_PROVINCE_V2 = "341c83f4a68111e698b964006a4684f0";
    
    /**
     * 权限 客户管理
     */
    public static final String PRIVILEGE_CUSTOMER_V2 = "37d3d19399524269b0a94a444cb98817";
    
    /**
     * 权限 其他组
     */
    public static final String PRIVILEGE_OTHER_V2 = "4f99dc0da68311e698b964006a4684f0";
    
    /**
     * 权限 市场
     */
    public static final String PRIVILEGE_MARKET_V2 = "5570177ca68311e698b964006a4684f0";
    
    /**
     * 权限 企业信息管理
     */
    public static final String PRIVILEGE_ENTERPRISEINFO_V2 = "614184b734b549e0a1e9643b2ace9dab";
    
    /**
     *权限 平台财务 
     */
    public static final String PRIVILEGE_PLATFORM_V2 = "773f5d20a71811e6ac7d64006a4684f0";
    
    /**
     * 权限 呼叫中心主管
     */
    public static final String PRIVILEGE_CALL_CHARGE_V2 = "7c675667a68011e698b964006a4684f0";
    
    /**
     * 权限 呼叫中心客服
     */
    public static final String PRIVILEGE_CALL_CLIENT_V2 = "c07a013ea68011e698b964006a4684f0";
    
    /**
     * 权限 商品管理
     */
    public static final String PRIVILEGE_COMMODITY_V2 = "7f0e7c3a66b447c698a0d93f4220c4e0";
    
    /**
     * 权限 账户管理
     */
    public static final String PRIVILEGE_ACCOUNT_V2 = "821197fdaa024b97baa6f0a36f6dd370";
    
    /**
     * 权限 部门和员工管理
     */
    public static final String PRIVILEGE_DEPARTMENT_V2 ="a018a89701fe426685e77061b51f6444";
    
    /**
     * 权限 信息维护组
     */
    public static final String PRIVILEGE_INFOMAINTENANCE_V2 = "a9f0f205e2dc43c6ab34aa8161ee24f7";
    
    /**
     * 权限 配送
     */
    public static final String PRIVILEGE_DELIVERY_V2 = "b0a718f7d985483394066e3e44148cd9";
    
    interface USER_STATUS {
        /* 用户状态：禁用*/
        String DISABLE = "02";

        /* 用户状态：启用*/
        String ENABLE = "01";

    }

    /**
     * 角色 终端店
     */
    public static final String USER_ROLE_T_ROLE = "T_ROLE";
    
    /**
     * 角色 管理员
     */
    public static final String USER_ROLE_B_R_ADMI = "B_R_ADMI";
    
    /**
     * 角色 销售员
     */
    public static final String USER_ROLE_B_R_SALE = "B_R_SALE";
    
    /**
     * 角色 采购员
     */
    public static final String USER_ROLE_B_R_PURC = "B_R_PURC";
    
    /**
     * 角色 配送员
     */
    public static final String USER_ROLE_B_R_SEND = "B_R_SEND";
}
