package com.siwei.frame.common.utils.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "权限")
public class Permission extends BaseEntity {
	
	@ApiModelProperty(value = "权限名称")
    private String name;

	@ApiModelProperty(value = "权限类型")
    private Integer permissionType;

	@ApiModelProperty(value = "权限对应url")
    private String url;

	@ApiModelProperty(value = "权限")
    private String permission;

	@ApiModelProperty(value = "父菜单权限id")
    private Integer parentMenuId;

	@ApiModelProperty(value = "所属系统码")
    private Integer belongSystem;
	
	@ApiModelProperty(value = "描述")
	private String describition;
	
	private Boolean permissionOn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public Integer getBelongSystem() {
        return belongSystem;
    }

    public void setBelongSystem(Integer belongSystem) {
        this.belongSystem = belongSystem;
    }

	public String getDescribition() {
		return describition;
	}

	public void setDescribition(String describition) {
		this.describition = describition;
	}

	public Boolean getPermissionOn() {
		return permissionOn;
	}

	public void setPermissionOn(Boolean permissionOn) {
		this.permissionOn = permissionOn;
	}
    
}