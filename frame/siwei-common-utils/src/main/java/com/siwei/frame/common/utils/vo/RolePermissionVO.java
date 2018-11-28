package com.siwei.frame.common.utils.vo;

import com.siwei.frame.common.utils.entity.BaseEntityVO;
import com.siwei.frame.common.utils.entity.Permission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(value = "角色权限")
public class RolePermissionVO extends BaseEntityVO {

	@NotNull(message = "角色id不能为空")
	@ApiModelProperty(value = "角色id", required = true)
	private Integer roleId;
	
	@NotNull(message = "所属系统码不能为空")
	@ApiModelProperty(value = "所属系统码", required = true)
	private Integer systemCode;
	
	@NotNull(message = "权限不能为空")
	@ApiModelProperty(value = "权限", required = true)
	private List<Permission> permissions;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getSystemCode() {
		return systemCode;
	}
	
	public void setSystemCode(Integer systemCode) {
		this.systemCode = systemCode;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
