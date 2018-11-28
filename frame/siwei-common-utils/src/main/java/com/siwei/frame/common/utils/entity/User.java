package com.siwei.frame.common.utils.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "用户")
public class User extends BaseEntity {
	
	@ApiModelProperty(value = "昵称")
	@NotBlank(message = "昵称不能为空")
    private String nickName;

	@ApiModelProperty(value = "真实姓名")
    private String realName;

	@ApiModelProperty(value = "手机号")
	@NotBlank(message = "手机号不能为空")
    private String mobile;

	@ApiModelProperty(value = "性别")
    private Integer sex;

	@ApiModelProperty(value = "头像地址")
    private String headImg;

	@ApiModelProperty(value = "所在省")
    private String province;

	@ApiModelProperty(value = "所在市")
    private String city;

	@ApiModelProperty(value = "所在区")
    private String county;

	@ApiModelProperty(value = "地址")
    private String address;

    private Boolean astackAdminSystem;

    private Boolean astackAgentSystem;

    private Boolean astackWebappSystem;

    private Boolean astackStatisticalSystem;

    private Boolean lifeInsuranceSystem;

    private Boolean dafengStatisticalSystem;
    
    private Boolean astackAgentSmallProgramSystem;

    private Boolean astackTocSmallProgramSystem;

    private Boolean spareSystemCode1;

    private Boolean spareSystemCode2;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getAstackAdminSystem() {
        return astackAdminSystem;
    }

    public void setAstackAdminSystem(Boolean astackAdminSystem) {
        this.astackAdminSystem = astackAdminSystem;
    }

    public Boolean getAstackAgentSystem() {
        return astackAgentSystem;
    }

    public void setAstackAgentSystem(Boolean astackAgentSystem) {
        this.astackAgentSystem = astackAgentSystem;
    }

    public Boolean getAstackWebappSystem() {
        return astackWebappSystem;
    }

    public void setAstackWebappSystem(Boolean astackWebappSystem) {
        this.astackWebappSystem = astackWebappSystem;
    }

    public Boolean getAstackStatisticalSystem() {
        return astackStatisticalSystem;
    }

    public void setAstackStatisticalSystem(Boolean astackStatisticalSystem) {
        this.astackStatisticalSystem = astackStatisticalSystem;
    }

    public Boolean getLifeInsuranceSystem() {
        return lifeInsuranceSystem;
    }

    public void setLifeInsuranceSystem(Boolean lifeInsuranceSystem) {
        this.lifeInsuranceSystem = lifeInsuranceSystem;
    }

    public Boolean getDafengStatisticalSystem() {
        return dafengStatisticalSystem;
    }

    public void setDafengStatisticalSystem(Boolean dafengStatisticalSystem) {
        this.dafengStatisticalSystem = dafengStatisticalSystem;
    }

    public Boolean getSpareSystemCode1() {
        return spareSystemCode1;
    }

    public void setSpareSystemCode1(Boolean spareSystemCode1) {
        this.spareSystemCode1 = spareSystemCode1;
    }

    public Boolean getSpareSystemCode2() {
        return spareSystemCode2;
    }

    public void setSpareSystemCode2(Boolean spareSystemCode2) {
        this.spareSystemCode2 = spareSystemCode2;
    }

	public Boolean getAstackAgentSmallProgramSystem() {
		return astackAgentSmallProgramSystem;
	}

	public void setAstackAgentSmallProgramSystem(Boolean astackAgentSmallProgramSystem) {
		this.astackAgentSmallProgramSystem = astackAgentSmallProgramSystem;
	}

	public Boolean getAstackTocSmallProgramSystem() {
		return astackTocSmallProgramSystem;
	}

	public void setAstackTocSmallProgramSystem(Boolean astackTocSmallProgramSystem) {
		this.astackTocSmallProgramSystem = astackTocSmallProgramSystem;
	}
    
}