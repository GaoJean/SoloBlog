package com.solo.common.exception;

public class TokenException extends Exception {

	private static final long serialVersionUID = -5669663585939713396L;
	
	public TokenException(){
		super();
	}
	
	public TokenException(String msg){
		super(msg);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
