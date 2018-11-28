package com.siwei.frame.common.utils.vo;

import com.siwei.frame.common.utils.entity.BaseEntityVO;
import com.siwei.frame.common.utils.entity.Permission;

import java.util.List;

public class PermissionReturnVO extends BaseEntityVO {
	
    private String name;

    private String permission;

    private Integer parentMenuId;
    
    private Boolean permissionOn;
    
    private List<Permission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Boolean getPermissionOn() {
		return permissionOn;
	}

	public void setPermissionOn(Boolean permissionOn) {
		this.permissionOn = permissionOn;
	}

}