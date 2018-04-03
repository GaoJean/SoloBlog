package com.gao.soloblog.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务常量
 */
public interface Constant {
	
	/** 手机号匹配正则表达式 */
	public static final String TEL_REGULAR_EXPRESSION = "^((\\(\\d{3}\\))|(\\d{3}\\-))?(1[34578]\\d{9})$";
	/** 手机号格式不合法 */
	public static final String TEL_INVALID = "telInvalid";
	/** 手机号已被注册 */
	public static final String TEL_DISABLED = "telDisabled";
	/** 手机号未注册 */
	public static final String TEL_NOT_REGISTER = "telNotRegister";
	/** 手机号未激活 */
	public static final String TEL_NOT_ACTIVATE = "telNotActivate";
	/** 短信发送间隔时间过短 */
	public static final String SEND_MSG_TIME_SHORT = "sendMsgTimeShort";
	/** 更改手机号-未调用获取原手机号验证码接口 */
	public static final String NOT_CALL_UNBIND_INTERFACE = "notCallUnbindInterface";
	/** 手机号在系统中已存在 */
	public static final String TEL_EXIST = "telExist";
	/** 激活手机号-短信验证码发送时间 */
	public static final String SEND_SMS_TIME = "sendSmsTime";
	/** 更改手机号-解绑手机短信验证码发送时间*/
	public static final String SEND_UNBIND_SMS_TIME = "sendUnbindSmsTime";
	/** 更改手机号-新手机短信验证码发送时间*/
	public static final String SEND_BIND_SMS_TIME = "sendBindSmsTime";
	/** 短信验证码 */
	public static final String SEND_SMS_CONTENT = "sendSmsContent";
	/** 更改手机号-用于激活新手机号码接口做最后的校验*/
	public static final String SEND_SMS_CONTENT_2 = "sendSmsContent2";
	/** 短信验证码所发送的手机号码 */
	public static final String SMS_SEND_TEL = "smsSendTel";
	/** 更改手机号-是否调用获取解绑手机短信验证码接口*/
	public static final String IS_CALL_UNBIND_INTERFACE = "isCallUnbindInterface";
	/** 货到付款订单卖家取消需求新增  订单下单时间期限*/
	public static final int DEADLINE_ORDER_CREATE_TIME = 30;
	
	/** ------- begin 许天赏：订单状态 ------- **/

	/** 未付款 **/
	public static final String STATUS_HEADER_01 = "C011";

	public static final String STATUS_TITLE_HEADER_01 = "待付款订单";
	/** 已关闭 **/
	public static final String STATUS_HEADER_02 = "C012";

	public static final String STATUS_TITLE_HEADER_02 = "订单取消";
	/** 申请退款 **/
	public static final String STATUS_HEADER_03 = "C013";

	public static final String STATUS_TITLE_HEADER_03 = "待付款订单";
	/** 退款中 **/
	public static final String STATUS_HEADER_04 = "C014";
	/** 已退款 **/
	public static final String STATUS_HEADER_05 = "C015";

	public static final String STATUS_TITLE_HEADER_05 = " 已退款订单";
	/** 已付款 **/
	public static final String STATUS_HEADER_06 = "C016";

	public static final String STATUS_TITLE_HEADER_06 = "待卖家发货订单";
	/** 已出库 and 配送中 **/
	public static final String STATUS_HEADER_07 = "C017";

	public static final String STATUS_TITLE_HEADER_07 = "待收货订单";
	/** 已收货 **/
	public static final String STATUS_HEADER_08 = "C018";
	/** 交易完成 **/
	public static final String STATUS_HEADER_09 = "C019";

	public static final String STATUS_TITLE_HEADER_09 = "交易完成订单";

	/** 待发货 **/
	public static final String STATUS_HEADER_20 = "C020";

	/** 配送完成 **/
	public static final String STATUS_HEADER_21 = "C021";

	/** 支付中（拆分过的订单才有这种状态）  **/
    public static final String STATUS_HEADER_25 = "C025";
	
	/** 订单处理状态-未支付 **/
	public static final String PAYMENT_ORDER_NOPAY = "P011";
	/** 订单处理状态-支付中 **/
	public static final String PAYMENT_ORDER_PAYING = "P012";
	/** 订单处理状态-已支付 **/
	public static final String PAYMENT_ORDER_PAYED = "P013";
	/** 订单处理状态-退款中 **/
	public static final String PAYMENT_ORDER_REFUNDING = "P009";
	/** 订单支付状态 -支付异常 **/
	public static final String PAYMENT_ORDER_EXCEPTION = "P014";
	/** 订单处理状态-订单关闭 **/
	public static final String PAYMENT_ORDER_CLOSE = "P014";
	/** 收货标示，只做标示用 **/
	public static final String PAYMENT_ORDER_FLAG = "P100";

	/** 支付记录类型-银联绑定 **/
	public static final String PAY_BIND_YL = "P0201";
	/** 支付记录类型-银联解绑 **/
	public static final String PAY_UNBIND_YL = "P0202";
	/** 支付记录类型-银联绑定代收支付 **/
	public static final String PAY_BINDTYPE_YL = "P0203";
	/** 支付记录类型-银联绑定消费支付 **/
	public static final String PAY_BINDCOUM_YL = "P0204";
	/** 支付记录类型-银联B2B支付 **/
	public static final String PAY_B2BCODE_YL = "P0205";
	/** 支付记录类型-银联商务支付 **/
	public static final String PAY_TYPECODE_YLSW = "P0206";
	/** 支付记录类型-银联绑定退款 **/
	public static final String REFUND_BINDTYPE_YL = "P0207";
	/** 支付记录类型-银联B2B退款 **/
	public static final String REFUND_B2BCODE_YL = "P0208";
	/** 支付记录类型-银联商务退款 **/
	public static final String REFUND_TYPECODE_YLSW = "P0209";
	/** 支付记录类型-银联商务对账 **/
	public static final String COMPARE_TYPECODE_YLSW = "P0210";
	/** 支付记录类型-银联商务确认收货 **/
	public static final String CONFIRM_TYPECODE_YLSW = "P0211";
	/** 支付记录类型-银联绑定状态查询 **/
	public static final String QUERY_BINDTYPE_YL = "P0212";
	/** 支付记录类型-银联交易状态查询 **/
	public static final String QUERY_PAYCODE_YL = "P0213";
	/** 支付记录类型-银联商务确认收货状态通知 **/
	public static final String CONFIRM_NOTIFY_YLSW = "P0214";

	/** 订单处理表类型-付款支付 **/
	public static final String ORDER_PAY_CODE = "P031";
	/** 订单处理表类型-退款支付 **/
	public static final String ORDER_REFUND_CODE = "P032";
	/** 订单处理表类型-确认收货支付 **/
	public static final String ORDER_CONFIRMPAY_CODE = "P033";

	/** ------- end 许天赏：订单状态 ------- **/

	/**
	 * 结算支付方式
	 */
	public static interface PayWay {
		/**
		 * 货到付款
		 */
		public String CASH_ON_DELIVERY = "2";

		/**
		 * 在线支付
		 */
		public String PAY_ONLINE = "1";

		/**
		 * 货到付款&在线支付
		 */
		public String COMPOSITE_WAY = "12";

		/**
		 * 公司转帐
		 */
		public String COMPANY_VIREMENT = "3";
	}
	
	public static interface ServiceCode {
		//controller返回给app 客户端的接口业务状态码
	    public static final String CODE_0 = "0";
	    public static final String CODE_1 = "1";
	    public static final String CODE_2 = "2";
	    public static final String CODE_3 = "3";
	    public static final String CODE_4 = "4";
	    public static final String CODE_5 = "5";
	    public static final String CODE_6 = "6";
	    public static final String CODE_9 = "9";
	    
	    public static final String SPLIT_SYMBOL = "_split_";
	    public static final String IOS_NULL = "(null)";
	    
	    public static final String PRIVILEGE_TERMINAL_SYSTEM_FLAG = "t;t";
	    public static final String PRIVILEGE_BUSINESS_SYSTEM_FLAG = "t;b";
	    /** “-”字符 **/
	    public static final String LINE = "-";
	    public static final String SESSION_ROLE = "session_role";
	}


	/**
	 * 商品图片类型 000-未选中; 001-详情; 010-相册; 011-相册/详情; 100-封面; 101-封面/详情; 110-封面/相册;
	 * 111-封面/相册/详情
	 * 
	 * */
	public static interface GOODS_PICTURE_TYPE {
		String NO_CHECK = "000"; // 未选中
		String DETAIL = "001"; // 详情
		String PHOTO_ALBUM = "010"; // 相册
		String PHOTO_ALBUM_DETAIL = "011"; // 相册/详情
		String COVER = "100"; // 封面
		String COVER_DETAIL = "101"; // 封面/详情
		String COVER_PHOTO_ALBUM = "110"; // 封面/相册
		String COVER_PHOTO_ALBUM_DETAIL = "111"; // 封面/相册/详情
	}

	/**
	 * 商品状态2期 0正常；1暂时缺货；2已下架;3已失效；4商品不存在；5商品已锁定 6:不在售卖时间
	 * 返回给APP客户端的商品状态
	 */
	public static interface GOODS_STATUS {
		String NORMAL = "0"; // 正常
		String NO_INVENTORY = "1"; // 暂时缺货
		String OFF_SHELF = "2"; // 已下架
		String INVALID = "3"; // 已失效
		String NO_EXIST = "4"; // 商品不存在
		String LOCKED = "5"; // 商品已锁定
		String NOT_SELLINGTIME = "6"; // 不在售卖时间内
	}
	
	/**
	 * 取消状态：0-正常状态 1-取消中状态 2-已同意取消状态 3-已拒绝取消状态  4-卖家取消，5-买家同意，6-买家拒绝
	 */
	public static interface CancelStatus {
		String NORMAL = "normal";	// 正常状态
		String CANCELING = "canceling";	// 订单取消中(买家发起)
		String AGREE = "agree";// 卖家同意
		String REFUSE = "refuse";// 卖家拒绝
		String CANCELING_BY_SELLER = "scanceling";// 订单取消中(卖家发起)
		String AGREE_BY_BUYER = "bagree";// 买家同意
		String REFUSE_BY_BUYER = "brefuse";// 买家拒绝
		
	}
	
	/**
     * 商品常量，数据库的物理设计
     *
     */
    public static interface DlGoods {
        
        public static String DELETE = "99";
        //商品状态:01-已上架,02-已下架,03-锁定,99-删除
        public static String SHELVE = "01";
        public static String OFF_SHELVE = "02";
        public static String LOCK = "03";
        
        //一级售卖权状态:01-启用;02-停用;03-冻结;99-删除
        public static String START = "01";
        public static String STOP = "02";
        public static String FREEZE = "03";
        // 终端店-all
        public static String TERMINAL_SHOP_ALL = "终端店-all";
        // 终端店code
        public static String TERMINAL_SHOP_ALL_CODE = "SALL";
        //一级售卖权状态:01-启用;02-停用;03-冻结;99-删除
        public static String SALES_RIGHT_STATUS_01 = "01";
        public static String SALES_RIGHT_STATUS_02 = "02";
        public static String SALES_RIGHT_STATUS_03 = "03";
        
        //新增页面1跳转，2返回
        public static String PAGE_CODE_ONE = "one";
        public static String PAGE_CODE_TWO = "two";
        //标识--新增 
        public static String PAGE_CODE_NEW = "new";        
        //获取商品单位列表
        public static String PROPERTY_ID_UNIT_NAME = "包装规格";        
        //价格类型 01:经销商 02：终端店
        public static String PRICE_TYPES = "priceType";
        
        public static String INIT_SALE_QUANTITY_S1S = "initSaleQuantityS1";
        public static String PRICE_S1S = "priceS1";
        public static String INIT_SALE_QUANTITY_S2S = "initSaleQuantityS2";
        public static String PRICE_S2S = "priceS2";
        public static String INIT_SALE_QUANTITY_S3S = "initSaleQuantityS3";
        public static String PRICE_S3S = "priceS3";        
        //特约价--买家等级
        public static String BUYER_LEVELS = "buyerLevel";        
        //特约商品价格类别为“03”
        public static String SPECIAL_GOODS_PRICE_TYPE = "03";
        
        public static String AREA_PARENT_CODES = "areaParentCode";        
        // 标识——编辑
        public static String PAGE_CODE_EDIT = "edit";
        // 未定级用户
        public static String UNDEFINE_USER = "B00";
        
        public static String GET_IS_CHECK = "1";
        public static String BIG_DECIMAL = "100";
        
        public static String RTN_CODE = "-1";
        
        // 后台校验 常量名 定义  开始
        public static String SELLER_ID = "sellerId";
        public static String GOODS_NAME = "goodsName";
        public static String GOODS_PROMOTION_INFO = "goodsPromotionInfo";
        public static String GOODS_COMMENT = "goodsComment";
        public static String PACKAGES_TYPE_PROPERTYCODE = "packagesTypePropertyCode";
        public static String PACKAGES_TYPE_PROPERTYVALUE = "packagesTypePropertyValue";
        public static String UNITS_CONVERTION = "unitsConvertion";
        public static String ON_HAND_INVENTORY = "onHandInventory";
        public static String PRICE_RETAIL = "priceRetail";
        public static String PRICE_DANLU = "priceDanlu";
        public static String GOODS_ID = "goodsId";
        public static String GOODS_NUMBER = "goodsNumber";
        public static String BUSINESS_INIT_SALE_QUANTITY = "businessInitSaleQuantity";
        public static String BUSINESS_PRICE = "businessPrice";
        public static String TERMINAL_INIT_SALE_QUANTITY = "terminalInitSaleQuantity";
        public static String TERMINAL_PRICE = "terminalPrice";
        public static String SPECIAL_INIT_SALE_QUANTITY = "specialInitSaleQuantity";
        public static String SPECIAL_PRICE = "specialPrice";
        // 后台校验 常量名 定义  结束
        
    }
	
	public static interface OrderStatus {

		/**
		 * 订单操作-发货
		 */
		public static String OPERATION_DELIVERGOODS = "operation_deliverGoods";
		/**
		 * 订单操作-拒绝取消订单
		 */
		public static String OPERATION_REFUSECANCEL = "operation_refuseCancel";
		/**
		 * 订单操作-同意取消订单
		 */
		public static String OPERATION_AGREECANCEL = "operation_agreeCancel";
		
}

	/**
	 * 订单操作信息
	 */
	public static interface orderOperateInfo {
		/**
		 * 取消
		 */
		public static String ORDER_OPERATE_CANCELE = "cancel";

		/**
		 * 买家取消订单
		 */
		public static String ORDER_BUYER_OPERATE_CANCELE_MESSAGE = "买家取消订单";

		/**
		 * 取消-货到付款-已发货
		 */
		public static String ORDER_OPERATE_CANCELDELIVERED = "cancelDelivered";

		/**
		 * 取消 退款
		 */
		public static String ORDER_OPERATE_REFUND = "refund";

		/**
		 * 买家取消订单(退款操作)
		 */
		public static String ORDER_OPERATE_REFUND_MESSAGE = "买家取消订单";

		/**
		 * 确认收获
		 */
		public static String ORDER_OPERATE_CONFIRM = "confirm";

		/**
		 * 买家确认收货
		 */
		public static String ORDER_OPERATE_CONFIRM_MESSAGE = "买家确认收货";

		/**
		 * 买家在卖家已发货状态下点击【取消订单】
		 */
		public static String ORDER_OPERATE_CANCELSTATUS_CANCEL = "canceling";

		/**
		 * 卖家同意取消订单
		 */
		public static String ORDER_OPERATE_CANCELSTATUS_AGREE = "agree";

		/**
		 * 拒绝取消订单则填refuse
		 */
		public static String ORDER_OPERATE_CANCELSTATUS_REFUSE = "refuse";

		public static String ORDER_BUYER_OPERATE_CANCELE_SUCCESS_MESSAGE = "取消订单成功";

		public static String ORDER_BUYER_OPERATE_CANCELE_DELIVERY_SUCCESS_MESSAGE = "成功提交申请取消交易审核";


	}

	/**
	 * 支付通道-银联
	 */
	public static String PAYCHANNEL_UNIONPAY = "00";
	/**
	 * 支付通道-联动优势
	 */
	public static String PAYCHANNEL_UMPAY = "01";
	/**
	 * 支付通道-易极付
	 */
	public static String PAYCHANNEL_EASYPAY = "02";
	/** 是否显示客户查看电话 **/
	public static final String customerPhoneShow = "01"; // 显示

	public static final String customerPhoneHide = "02"; // 不显示

	
	/**
     * 待付款
     */
    public static final String PENDING_PAY_CODE = "C011";

    /**
     * 待发货
     */
    public static final String WAITING_SHIPPMENT_CODE = "C020";

    /**
     * 待收货
     */
    public static final String WAITING_RECEIVE_CODE = "C017";

    /**
     * 交易完成
     */
    public static final String TRADE_FINISH_CODE = "C019";

    /**
     * 交易取消
     */
    public static final String TRADE_CANCEL_CODE = "C012";

    /**
     * 退款取消
     */
    public static final String REFUND_CANCEL_CODE = "C015";

    /**
     * 交易异常
     */
    public static final String TRADE_ERROR_CODE = "P014";

    /**
     * 商品 已上架
     */
    public static final String MERCH_NORMAL_CODE = "0";

    /**
     * 商品 暂时缺货
     */
    public static final String MERCH_OUT_OF_STOCK = "1";

    /**
     * 商品 已下架
     */
    public static final String MERCH_OFF_SHELF = "2";

    /**
     * 商品 已失效
     */
    public static final String MERCH_INVALID = "3";

    /**
     * 商品 不存在
     */
    public static final String MERCH_NOT_EXISTS = "4";

    /**
     * 商品 锁定
     */
    public static final String MERCH_LOCKED = "5";
    
    /**
     * 商品 不在售卖时间内
     */
    public static final String MERCH_NOT_SELLINGTIME = "6";
	/**
	 * 满赠
	 */
	public static final String FULL_ADD = "0";

	/**
	 * 满降
	 */
	public static final String FULL_DOWN = "1";
	
	/**
	 * 减单价
	 */
	public static final String DOWN_UNIT_PRICE = "0";

	/**
	 * 减总价
	 */
	public static final String DOWN_TOTAL_PRICE = "1";
    
    
    
    /** 商品不存在 **/
    public static final String NOT_EXIST    = "【商品不存在】";
    
    /** 商品下架 **/
    public static final String SHELVESOFF       = "【商品已下架】";
    
    /** 商品失效 **/
    public static final String INVALID          = "【商品已失效】";
    
    /** 商品缺货 **/
    public static final String LOCKED    = "【商品已锁定】";
    
    /** 商品缺货 **/
    public static final String SHORT_SUPPLY     = "【商品缺货】";
    
    /** 商品不在售卖时间内 **/
    public static final String NOT_SELLINGTIME     = "【商品不在售卖时间内】";
    
    
    /** 终端商审批申请号 **/
    public static final String GENERATE_APPLY_NO_TAL                    = "TAL";
    
    /**申请单号存放到session中**/
    public static final String SESSION_APPLY_ID                               = "session_apply_id";
    
    /**登录名存放到session中**/
    public static final String SESSION_APPLY_LOGIN_NAME                       = "session_login_name";

    /**注册申请用户的申请密码放到session中*/
    public static final String SESSION_APPLY_PWD							  = "session_login_pwd";
    
    /**用户当前审批状态：待审核（丹露）**/
    public static final String FLOW_STATUS_WAIT_APP                           = "02";
    
    /** 新增配送商地址申请号 **/
    public static final String GENERATE_APPLY_NO_BAA = "BAA";

    /** 商品类目  白酒**/
    public static final String CATEGORY_SPIRIT                          = "C01L0101";
    /** 商品类目  葡萄酒**/
    public static final String CATEGORY_WINE                            = "C01L0102";
    /** 商品类目  洋酒**/
    public static final String CATEGORY_FOREIGN_WINE                    = "C01L0103";
    /** 商品类目  啤酒**/
    public static final String CATEGORY_BEER                            = "C01L0104";
    /** 商品类目  茶**/
    public static final String CATEGORY_TEE                             = "C01T01";
    /** 商品类目  饮料**/
    public static final String CATEGORY_DRINK                           = "C01X01";
    /** 商品类目  其它饮品 ios兼容性保留代码，bug#7914:C01X0101类码处理**/
    public static final String CATEGORY_OTHER_DRINK                     = "C01X0101";
    /** 商品类目  粮油**/
    public static final String CATEGORY_GRAIN_OIL                       = "C01G01";
    /** 商品类目  副食**/
    public static final String CATEGORY_SUBSIDIARY_FOOD                 = "C01F01";
    /** 商品类目  其它**/
    public static final String CATEGORY_OTHERS                 			= "C01E01";
    /** 商品类目  日化用品**/
    public static final String CATEGORY_THE_DALIY              			= "C01P01";
    /** 商品类目  五金**/
    public static final String CATEGORY_HARDWARE                 		= "C01H01";
    /** 商品类目  家电**/
    public static final String CATEGORY_HOUSE_ELECTRIC                 	= "C01J01";
    
    /** 商品属性值  白酒**/
    public static final String CATEGORY_PROPERTY_MODULE_SPIRIT                     = "M01L0101";
    /** 商品属性值  葡萄酒**/
    public static final String CATEGORY_PROPERTY_MODULE_WINE                       = "M01L0102";
    /** 商品属性值  洋酒**/
    public static final String CATEGORY_PROPERTY_MODULE_FOREIGN_WINE               = "M01L0103";
    /** 商品属性值  啤酒**/
    public static final String CATEGORY_PROPERTY_MODULE_BEER                       = "M01L0104";
    /** 商品属性值  绿茶**/
    public static final String CATEGORY_PROPERTY_MODULE_GREEN_TEE                  = "M01T0101";
    /** 商品属性值  绿茶**/
    public static final String CATEGORY_PROPERTY_MODULE_GREEN_TEA                  = "M01T0101";
    /** 商品属性值  红茶**/
    public static final String CATEGORY_PROPERTY_MODULE_RED_TEA                    = "M01T0102";
    /** 商品属性值  黑茶**/
    public static final String CATEGORY_PROPERTY_MODULE_DARK_TEA                   = "M01T0103";
    /** 商品属性值  乌龙茶**/
    public static final String CATEGORY_PROPERTY_MODULE_OOLONG_TEA                 = "M01T0104";
    /** 商品属性值  黄茶**/
    public static final String CATEGORY_PROPERTY_MODULE_YELLOW_TEA                 = "M01T0105";
    /** 商品属性值  黄茶**/
    public static final String CATEGORY_PROPERTY_MODULE_WHITE_TEA                  = "M01T0106";
    /** 商品属性值  花果茶**/
    public static final String CATEGORY_PROPERTY_MODULE_FRUIT_TEA                  = "M01T0107";
    /** 商品属性值  茶具**/
    public static final String CATEGORY_PROPERTY_MODULE_TEASET_TEA                 = "M01T0108";
    /** 商品属性值  饮料**/
    public static final String CATEGORY_PROPERTY_MODULE_DRINK                      = "M01X0101";
    
    public static final String PROPERTY_TYPE_TEA_TYPE					= "茶种";
    public static final String PROPERTY_TYPE_ODOR						= "香型";
    public static final String PROPERTY_TYPE_ORIGIN						= "产地";
    public static final String PROPERTY_TYPE_CLASS						= "商品类型";
    public static final String PROPERTY_TYPE_CATEGORY					= "种类";
    
    public static final String APP_RECOMMEND_GROUP_NAME = "appRecommendGroupName";
    public static final String APP_AREA_GROUP_NAME = "appAreaGroupName";
    public static final String APP_FAVORITES_GROUP_NAME = "appFavosGroupName";
    

    /** 新增终端商地址申请号 **/
    public static final String GENERATE_APPLY_NO_TAA = "TAA";

    /** 修改配送商地址申请号 **/
    public static final String GENERATE_APPLY_NO_BMA = "BMA";

    /** 修改终端商地址申请号 **/
    public static final String GENERATE_APPLY_NO_TMA = "TMA";
    
    /** 发票类型：普通发票 **/
    public static final String INVOICE_TYPE_N011 = "N011";
    
    /** 发票类型：增值税发票 **/
    public static final String INVOICE_TYPE_N012 = "N012";

    /**用户当前审批状态：待审核（经销商）**/
    public static final String FLOW_STATUS_WAIT_APP_BUSSINESS                 = "03";
    
    /** 短信模板常量 **/
    public static final String LOGINNAME                      = "LoginName";
    public static final String LOGINPWD                       = "LoginPwd";
    public static final String SMS_TEL_ACTIVATE               = "SMS_TEL_ACTIVATE";
    public static final String SMS_PAYMENT                    = "SMS_PAYMENT";
    public static final String INTERFACEID                    = "InterFaceID";
    public static final String SMS_TEL_UNBUNDING              = "SMS_TEL_UNBUNDING";
    public static final String SMS_COUPON_VALIDATE            = "SMS_COUPON_VALIDATE";
    public static final String SMS_FORGETPASSWORD             = "SMS_FORGETPASSWORD";
    
    /** 加入购物车时，输入购买数量的限制大小**/
    public static final Integer PURCHASE_LIMIT_NUMBER                = 1000000000;
    /** 业务员邀请语固定部分 **/
    public static String BUSINESSER_FIXED_LANGUAGE = "我是%1$s的业务员%2$s，现诚挚邀请您入驻丹露平台。在注册时输入我们的邀请码%3$s即可申请注册。";
   
    /** 企业邀请语固定部分 **/
    public static String COMPANY_FIXED_LANGUAGE = "我是%1$s，我加入了全国首个产业互联网平台-丹露网。在注册时输入我们的邀请码%2$s即可申请注册。";
    public class TaxRate {
    	
    	public static Map<String, String> raxMap = new HashMap<String, String>();
    	// 北京省增值税发票
    	public static String TVA_TAX_RATE_N012_P001 = "0.05";
    	// 北京省普通发票
    	public static String TVA_TAX_RATE_N011_P001 = "0";
    	// 天津省增值税发票
    	public static String TVA_TAX_RATE_N012_P002 = "0.05";
    	// 天津省普通发票
    	public static String TVA_TAX_RATE_N011_P002 = "0";
    	// 河北省增值税发票
    	public static String TVA_TAX_RATE_N012_P003 = "0.05";
    	// 河北省普通发票
    	public static String TVA_TAX_RATE_N011_P003 = "0";
    	// 山西省增值税发票
    	public static String TVA_TAX_RATE_N012_P004 = "0.05";
    	// 山西省普通发票
    	public static String TVA_TAX_RATE_N011_P004 = "0";
    	// 内蒙古省增值税发票
    	public static String TVA_TAX_RATE_N012_P005 = "0.05";
    	// 内蒙古省普通发票
    	public static String TVA_TAX_RATE_N011_P005 = "0";
    	// 辽宁古省增值税发票
    	public static String TVA_TAX_RATE_N012_P006 = "0.05";
    	// 辽宁省普通发票
    	public static String TVA_TAX_RATE_N011_P006 = "0";
    	// 吉林省增值税发票
    	public static String TVA_TAX_RATE_N012_P007 = "0.05";
    	// 吉林省普通发票
    	public static String TVA_TAX_RATE_N011_P007 = "0";
    	// 黑龙江省增值税发票
    	public static String TVA_TAX_RATE_N012_P008 = "0.05";
    	// 黑龙江省普通发票
    	public static String TVA_TAX_RATE_N011_P008 = "0";
    	// 上海省增值税发票
    	public static String TVA_TAX_RATE_N012_P009 = "0.05";
    	// 上海省普通发票
    	public static String TVA_TAX_RATE_N011_P009 = "0";
    	// 江苏省增值税发票
    	public static String TVA_TAX_RATE_N012_P010 = "0.05";
    	// 江苏省普通发票
    	public static String TVA_TAX_RATE_N011_P010 = "0";
    	// 浙江省增值税发票
    	public static String TVA_TAX_RATE_N012_P011 = "0.05";
    	// 浙江省普通发票
    	public static String TVA_TAX_RATE_N011_P011 = "0";
    	// 安徽省增值税发票
    	public static String TVA_TAX_RATE_N012_P012 = "0.05";
    	// 安徽省普通发票
    	public static String TVA_TAX_RATE_N011_P012 = "0";
    	// 福建省增值税发票
    	public static String TVA_TAX_RATE_N012_P013 = "0.05";
    	// 福建省普通发票
    	public static String TVA_TAX_RATE_N011_P013 = "0";
    	// 江西省增值税发票
    	public static String TVA_TAX_RATE_N012_P014 = "0.05";
    	// 江西省普通发票
    	public static String TVA_TAX_RATE_N011_P014 = "0";
    	// 山东省增值税发票
    	public static String TVA_TAX_RATE_N012_P015 = "0.05";
    	// 山东省普通发票
    	public static String TVA_TAX_RATE_N011_P015 = "0";
    	// 河南省增值税发票
    	public static String TVA_TAX_RATE_N012_P016 = "0.05";
    	// 河南省普通发票
    	public static String TVA_TAX_RATE_N011_P016 = "0";
    	// 湖北省增值税发票
    	public static String TVA_TAX_RATE_N012_P017 = "0.05";
    	// 湖北省普通发票
    	public static String TVA_TAX_RATE_N011_P017 = "0";
    	// 湖南省增值税发票
    	public static String TVA_TAX_RATE_N012_P018 = "0.05";
    	// 湖南省普通发票
    	public static String TVA_TAX_RATE_N011_P018 = "0";
    	// 广东省增值税发票
    	public static String TVA_TAX_RATE_N012_P019 = "0.05";
    	// 广东省普通发票
    	public static String TVA_TAX_RATE_N011_P019 = "0";
    	// 广西省增值税发票
    	public static String TVA_TAX_RATE_N012_P020 = "0.05";
    	// 广西省普通发票
    	public static String TVA_TAX_RATE_N011_P020 = "0";
    	// 海南省增值税发票
    	public static String TVA_TAX_RATE_N012_P021 = "0.05";
    	// 海南省普通发票
    	public static String TVA_TAX_RATE_N011_P021 = "0";
    	// 重庆省增值税发票
    	public static String TVA_TAX_RATE_N012_P022 = "0.05";
    	// 重庆省普通发票
    	public static String TVA_TAX_RATE_N011_P022 = "0";
    	// 四川省增值税发票
    	public static String TVA_TAX_RATE_N012_P023 = "0.05";
    	// 四川省普通发票
    	public static String TVA_TAX_RATE_N011_P023 = "0";
    	// 贵州省增值税发票
    	public static String TVA_TAX_RATE_N012_P024 = "0.05";
    	// 贵州省普通发票
    	public static String TVA_TAX_RATE_N011_P024 = "0";
    	// 云南省增值税发票
    	public static String TVA_TAX_RATE_N012_P025 = "0.05";
    	// 云南省普通发票
    	public static String TVA_TAX_RATE_N011_P025 = "0";
    	// 西藏省增值税发票
    	public static String TVA_TAX_RATE_N012_P026 = "0.05";
    	// 西藏省普通发票
    	public static String TVA_TAX_RATE_N011_P026 = "0";
    	// 陕西省增值税发票
    	public static String TVA_TAX_RATE_N012_P027 = "0.05";
    	// 陕西省普通发票
    	public static String TVA_TAX_RATE_N011_P027 = "0";
    	// 甘肃省增值税发票
    	public static String TVA_TAX_RATE_N012_P028 = "0.05";
    	// 甘肃省普通发票
    	public static String TVA_TAX_RATE_N011_P028 = "0";
    	// 青海省增值税发票
    	public static String TVA_TAX_RATE_N012_P029 = "0.05";
    	// 青海省普通发票
    	public static String TVA_TAX_RATE_N011_P029 = "0";
    	// 宁夏省增值税发票
    	public static String TVA_TAX_RATE_N012_P030 = "0.05";
    	// 宁夏省普通发票
    	public static String TVA_TAX_RATE_N011_P030 = "0";
    	// 新疆省增值税发票
    	public static String TVA_TAX_RATE_N012_P031 = "0.05";
    	// 新疆省普通发票
    	public static String TVA_TAX_RATE_N011_P031 = "0";
    	// 香港省增值税发票
    	public static String TVA_TAX_RATE_N012_P032 = "0.05";
    	// 香港省普通发票
    	public static String TVA_TAX_RATE_N011_P032 = "0";
    	// 澳门省增值税发票
    	public static String TVA_TAX_RATE_N012_P033 = "0.05";
    	// 澳门省普通发票
    	public static String TVA_TAX_RATE_N011_P033 = "0";
    	// 台湾省增值税发票
    	public static String TVA_TAX_RATE_N012_P034 = "0.05";
    	// 台湾省普通发票
    	public static String TVA_TAX_RATE_N011_P034 = "0";
    	
    	public static String TVA_TAX_RATE_N012_DEFAULT = "0.05";
    	
    	public static String TVA_TAX_RATE_N011_DEFAULT = "0";
	
    	static {
    		raxMap.put("TVA_TAX_RATE_N012_P001", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P001", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P002", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P002", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P003", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P003", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P004", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P004", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P005", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P005", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P006", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P006", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P007", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P007", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P008", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P008", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P009", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P009", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P010", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P010", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P011", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P011", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P012", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P012", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P013", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P013", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P014", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P014", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P015", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P015", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P016", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P016", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P017", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P017", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P018", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P018", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P019", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P019", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P020", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P020", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P021", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P021", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P022", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P022", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P023", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P023", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P024", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P024", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P025", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P025", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P026", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P026", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P027", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P027", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P028", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P028", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P029", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P029", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P030", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P030", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P031", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P031", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P032", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P032", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P033", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P033", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_P034", TVA_TAX_RATE_N012_P001);
    		raxMap.put("TVA_TAX_RATE_N011_P034", TVA_TAX_RATE_N011_P001);
    		raxMap.put("TVA_TAX_RATE_N012_DEFAULT", TVA_TAX_RATE_N012_DEFAULT);
    		raxMap.put("TVA_TAX_RATE_N011_DEFAULT", TVA_TAX_RATE_N011_DEFAULT);
    	}
    }
    
    public static interface INTERFACE_BUSINESS {
        // 建立绑定
        public int    PB_BIND_TYPE              = 1;
        // 解除绑定
        public int    PB_UNBIND_TYPE            = 2;
        // 查询绑定关系
        public int    PB_BIND_QUERY_TYPE        = 3;
        // 绑定代收
        public int    PB_PAY_COLLECTION_TYPE    = 4;
        // 绑定消费
        public int    PB_PAY_EXPENSE_TYPE       = 5;
        // 交易状态查询
        public int    PB_PAY_QUERY_TYPE         = 6;
        // 绑定消费撤销
        public int    PB_PAY_CANCEL_TYPE        = 7;
        // 短信验证码
        public int    PB_SEND_VALIDATECODE_TYPE = 8;
        // B2B支付
        public int    B2B_PAY_CONSUME_TYPE      = 9;
        // B2B退货
        public int    B2B_PAY_CANCEL_TYPE       = 10;
        // B2B交易查询
        public int    B2B_PAY_QUERY_TYPE        = 11;
        // 银联商务付款
        public int    YLSW_PAY_CONSUME_TYPE     = 12;
        // 银联商务退款
        public int    YLSW_PAY_CANCEL_TYPE      = 13;
        // 银联商务确认收货状态通知
        public int    YLSW_CONFIRM_NOTIFY_TYPE  = 14;
        //0720
        public String COD_FLG_SUPPORT           = "2"; // 货到付款
        public String COD_FLG_UNSUPPORT         = "1"; // 不支持货到付款
        public String PAYMENT_FLG_SUPPORT       = "0"; //付款标识:0（支持），
        public String PAYMENT_FLG_UNSUPPORT     = "1"; //付款标识:1（不支持）
        
        //促销优化时增加
        public String IS_PAYONLINE_SUPPORT = "1"; //在线支付:0-不支持,1-支持
        public String IS_PAYONLINE_UNSUPPORT = "0";
        public String IS_COD_SUPPORT = "1";//货到付款:0-不支持,1-支持
        public String IS_COD_UNSUPPORT = "0";
        public String IS_SUPPLY_INVOICE = "1";//开增值税发票:0-不支持,1-支持
        public String IS_NOTSUPPLY_INVOICE = "0";
    }
    
    /**
     * session 和 cookie的Key
     */
    public static interface SESSION_AND_COOKIE {

        // 用户对象 TerminalExt / BusinessUserExtendsExt
        String SESSION_USER                 = "session_user";
        // 用户对象 UserInfo
        String SESSION_USER_INFO            = "session_user_info";
        // 公司采购信息对象 DlBizPurchaseDTO
        String SESSION_COMPANY_PURCHASE     = "session_company_purchase";
        // 用户ID
        String SESSION_USER_ID              = "session_user_id";
        // 企业id
        String SESSION_COMPANY_ID           = "session_company_id";
        // 配送商ID
        String SESSION_BUSINESS_CUSTOMER_ID = "session_business_customer_id";
        // 终端商ID
        String SESSION_TERMINAL_CUSTOMER_ID = "session_terminal_customer_id";
        // 登陆用户名
        String SESSION_USERNAME             = "session_userName";
        // 用户企业名
        String SESSION_COMPANY_NAME         = "session_company_name";
        // 注册所在省
        String SESSION_PROVINCE             = "session_province";
        // 注册所在市
        String SESSION_CITY                 = "session_city";
        // 注册所在区
        String SESSION_DISTRICT             = "session_district";
        // 注册区域 等价于 CHN + 注册省 + 注册市 + 注册区
        String SESSION_AREA                 = "session_area";
        // 采购区域省
        String SESSION_PURCHASE_PROVINCE    = "session_purchase_province";
        // 采购区域市
        String SESSION_PURCHASE_CITY        = "session_purchase_city";
        // 采购区域区
        String SESSION_PURCHASE_DISTRICT    = "session_purchase_district";
        // 采购区域 等价于 CHN + 采购省 + 采购市 + 采购区
        String SESSION_PURCHASE_AREA        = "session_purchase_area";
        // 用户类型
        String SESSION_USER_TYPE            = "session_user_type";
        // 用户令牌(手机端使用)
        String SESSION_TOKEN                = "session_token";
        // 登陆时间
        String SESSION_LOGIN_TIME           = "session_login_time";
        // 登陆IP
        String SESSION_LOGIN_IP             = "session_login_ip";
        // 手机号
        String SESSION_TEL                  = "session_tel";
        // 手机号状态
        String SESSION_TEL_STATUS           = "session_tel_status";
        // 注册时间
        String SESSION_FIRST_ACTIVE_TIME    = "session_first_active_time";
        // 会员等级
        String SESSION_WEBSITE_MEMBER_LEVEL = "session_website_member_level";
        //正在注册的用户对象
        String SESSION_APPLYING_USER_DTO    = "session_applying_user_dto";
        // 手机验证码
        String MOBILE_CODE                  = "mobile_code";
        // 商家类型
        String LOGIN_CUSTOMER_ROLE          = "loginCustomerRole";
        // 可售卖商品列表
        String SESSION_SALES_APPLY_LIST     = "session_sales_apply_list";
        // 购物车商品数量
        String SHOPPING_CAR_NUMBER          = "shopping_car_number";
        // 消息数量
        String MESSAGES_NUMBER              = "messages_number";
        // 最后一次使用的协议
        String SESSION_LAST_PROTOCOL        = "session_last_protocol";
        // 最后一次使用的端口
        String SESSION_LAST_PORT            = "session_last_port";
        //权限
        String SESSION_AUTHORITION          = "session_authorition";
        //角色
        String SESSION_ROLE					= "session_role";
    }
    
    // 促销类型常量
    public static interface PromotionType {
        public static String Limit = "4";// 限购
    }
    
    public static final String All_TIME_SELL = "1"; // 全时段售卖
    
    public static final String SPECIFY_TIME_SELL = "2"; // 指定时段售卖
    public static final int PAGE_CURRENT = 0;
    public static final int PAGE_SIZE = 15;
}
