package com.wqf.jarmanager.modal;

import java.io.Serializable;

/**
 * 算法信息
 * @author 24393
 *
 */
public class Algorition implements Serializable {

	private static final long serialVersionUID = 1L;

	//算法Id
	private String algoritionId;
	
	//算法名称
	private String algoritionName;
	
	//算法人口
	private String algoritionClass;
	
	//算法描述
	private String algoritionDose;

	public String getAlgoritionId() {
		return algoritionId;
	}

	public void setAlgoritionId(String algoritionId) {
		this.algoritionId = algoritionId;
	}

	public String getAlgoritionName() {
		return algoritionName;
	}

	public void setAlgoritionName(String algoritionName) {
		this.algoritionName = algoritionName;
	}

	public String getAlgoritionDose() {
		return algoritionDose;
	}

	public void setAlgoritionDose(String algoritionDose) {
		this.algoritionDose = algoritionDose;
	}

	public String getAlgoritionClass() {
		return algoritionClass;
	}

	public void setAlgoritionClass(String algoritionClass) {
		this.algoritionClass = algoritionClass;
	}

	@Override
	public String toString() {
		return "Algorition [algoritionId=" + algoritionId + ", algoritionName=" + algoritionName + ", algoritionClass="
				+ algoritionClass + ", algoritionDose=" + algoritionDose + "]";
	}
	
}
