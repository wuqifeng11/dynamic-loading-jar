package com.wqf.jarmanager.modal;

import java.io.Serializable;

/**
 * 规则信息
 * @author 24393
 *
 */
public class Rules implements Serializable {

	private static final long serialVersionUID = 1L;

	//规则Id
	private String roleId;
	
	//规则名称
	private String roleName;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Rules [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
}
