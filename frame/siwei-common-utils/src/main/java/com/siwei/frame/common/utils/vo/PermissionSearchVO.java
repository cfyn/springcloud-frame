package com.siwei.frame.common.utils.vo;

import com.siwei.frame.common.utils.entity.BaseEntityVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(value = "权限查询VO")
public class PermissionSearchVO extends BaseEntityVO {
	
	@NotNull(message = "用户id不能为空")
	@ApiModelProperty(value = "用户id", required = true)
	private Integer userId;
	
	@NotNull(message = "角色id不能为空")
	@ApiModelProperty(value = "角色id", required = true)
	private Integer roleId;
	
	@NotNull(message = "所属系统码不能为空")
	@ApiModelProperty(value = "所属系统码", required = true)
	private Integer systemCode;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

}