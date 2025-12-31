package com;

public enum StatusCode {
	
	SUCCESS(200), NOTFOUND(401), BADREQUEST(404), INTERNALSERVERERROR(500);
	
	int code;
	
	private StatusCode(int code){
		this.code=code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	

}
