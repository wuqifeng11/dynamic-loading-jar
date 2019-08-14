package com.wqf.jarmanager.modal;

public class ErrorCode {
	
	//状态码
	private String code;
	
	//描述
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "ErrorCode [code=" + code + ", desc=" + desc + "]";
	}
	
}
