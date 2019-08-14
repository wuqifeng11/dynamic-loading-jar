package com.wqf.jarmanager.modal;

import java.io.Serializable;

public class ParamEX implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//git地址
	private String gitUrl;
	
	//git分支
	private String branchOrTag;
	
	//资源路径
	private String sourcePath;
	
	//接口地址
	private String urlPath;
	
	//入参名称
	private String paramName;
	
	//入参类型
	private String paramType;

	public String getGitUrl() {
		return gitUrl;
	}

	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}

	public String getBranchOrTag() {
		return branchOrTag;
	}

	public void setBranchOrTag(String branchOrTag) {
		this.branchOrTag = branchOrTag;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	@Override
	public String toString() {
		return "ParamEX [gitUrl=" + gitUrl + ", branchOrTag=" + branchOrTag + ", sourcePath=" + sourcePath
				+ ", urlPath=" + urlPath + ", paramName=" + paramName + ", paramType=" + paramType + "]";
	}

}
