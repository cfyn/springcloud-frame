package com.siwei.frame.common.utils.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "用户登录信息")
public class UserLogin extends BaseEntity {
	
	@ApiModelProperty(value = "登录类型")
    private Integer identityType;

	@ApiModelProperty(value = "第三方应用唯一标识")
	@NotBlank(message = "用户名/邮箱/手机号不能为空")
    private String identifier;

	@ApiModelProperty(value = "密码凭证")
	@NotBlank(message = "密码不能为空")
    private String credential;

	@ApiModelProperty(value = "用户id")
    private Integer userId;
    
    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}