package com.siwei.frame.common.utils.vo;

import com.siwei.frame.common.utils.entity.BaseEntityVO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserLoginVO extends BaseEntityVO {

    private Integer identityType;

	@NotBlank(message = "用户名/邮箱/手机号不能为空")
    private String identifier;

	@NotBlank(message = "密码不能为空")
    private String credential;

    private Integer userId;
	
    @NotNull(message = "系统码不能为空")
	private Integer systemCode;
    
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

	public Integer getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(Integer systemCode) {
		this.systemCode = systemCode;
	}
    
}
