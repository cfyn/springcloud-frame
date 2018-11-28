package com.siwei.frame.common.utils.vo;

import com.siwei.frame.common.utils.entity.BaseEntityVO;
import com.siwei.frame.common.utils.helper.groups.UpdateValidGroup;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;

public class UserVO extends BaseEntityVO {
	
	@NotNull(message = "系统码不能为空")
	@Min(value = 1, message = "系统码错误")
	private Integer systemCode;

	@NotNull(message = "用户登录信息id为空")
	@Min(value = 1, message = "用户登录信息id错误")
	private Integer userLoginId;
	
    private String nickName;

    private String realName;

	@NotBlank(message = "手机号不能为空", groups = {Default.class, UpdateValidGroup.class})
	@Pattern(regexp = "^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$", message = "手机号格式不正确")
    private String mobile;

    private Integer sex;

    private String headImg;

    private String province;

    private String city;

    private String county;

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

	public Integer getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(Integer systemCode) {
		this.systemCode = systemCode;
	}

	public Integer getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
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
