package com.siwei.frame.common.utils.entity;

import com.siwei.frame.common.utils.helper.groups.EntitySearchValidGroup;
import com.siwei.frame.common.utils.helper.groups.UpdateValidGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@ApiModel(value = "角色")
public class Role extends BaseEntity {
	
	@ApiModelProperty(value = "角色名称")
	@NotBlank(message = "角色名称不能为空", groups = {Default.class, UpdateValidGroup.class})
    private String name;

	@ApiModelProperty(value = "角色编码")
	@NotBlank(message = "角色编码不能为空", groups = {Default.class, UpdateValidGroup.class})
    private String role;

	@ApiModelProperty(value = "所属系统码")
	@NotNull(message = "所属系统码不能为空", groups = {Default.class, EntitySearchValidGroup.class})
    private Integer belongSystem;
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getBelongSystem() {
        return belongSystem;
    }

    public void setBelongSystem(Integer belongSystem) {
        this.belongSystem = belongSystem;
    }

}