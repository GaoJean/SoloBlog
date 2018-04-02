package com.gao.soloblog.common.constant;

public enum SystemEnum {
    token_expire(100,"token验证失败，请重新登录!"),
	success_200(200,"执行成功!"),
	wrong_role(300, "错误的权限!"),
	illegal_argument(400, "非法的参数!"),
	server_exception(500, "服务器异常!"),
	re_login(600, "请重新登陆");

    
	private String value;
	private int index;

	private SystemEnum(int index, String value) {
		this.index = index;
		this.value = value;
	}

	public static String getValue(int index) {
		for (SystemEnum p : SystemEnum.values()) {
			if (p.getIndex()==index) {
				return p.value;
			}
		}
		return "";
	}

	public String getValue() {
		return value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
