package com.lz.algorithmManager.modal;

import java.io.Serializable;

public class Param implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//算法名称
	private String alName;
	
	//扩展参数
	private ParamEX paramEX;

	public String getAlName() {
		return alName;
	}

	public void setAlName(String alName) {
		this.alName = alName;
	}

	public ParamEX getParamEX() {
		return paramEX;
	}

	public void setParamEX(ParamEX paramEX) {
		this.paramEX = paramEX;
	}

	@Override
	public String toString() {
		return "Paramter [alName=" + alName + ", paramEX=" + paramEX + "]";
	}

}
