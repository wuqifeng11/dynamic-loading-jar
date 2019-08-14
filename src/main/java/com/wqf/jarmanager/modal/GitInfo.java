package com.wqf.jarmanager.modal;

public class GitInfo {
	
	//状态信息
	private ErrorCode errorCode;
	
	//返回路径
	private String sourcePath;

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErroCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	@Override
	public String toString() {
		return "GitInfo [erroCode=" + errorCode + ", sourcePath=" + sourcePath + "]";
	}

}
