package com.siwei.frame.user.consumer.service;

import com.siwei.frame.common.utils.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("测试")
public class Test extends BaseEntity {

	@ApiModelProperty(value = "boolean测试1")
	private boolean test1;
	
	@ApiModelProperty(value = "Boolean测试2")
	private Boolean test2;
	
	@ApiModelProperty(value = "Date测试3")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date test3;
	
	@ApiModelProperty(value = "double测试4")
	private double test4;
	
	@ApiModelProperty(value = "Double测试5")
	private Double test5;
	
	@ApiModelProperty(value = "Integer测试6")
	private Integer test6;
	
	@ApiModelProperty(value = "String测试7")
	private String test7;

	public boolean isTest1() {
		return test1;
	}

	public void setTest1(boolean test1) {
		this.test1 = test1;
	}

	public Boolean getTest2() {
		return test2;
	}

	public void setTest2(Boolean test2) {
		this.test2 = test2;
	}

	public Date getTest3() {
		return test3;
	}

	public void setTest3(Date test3) {
		this.test3 = test3;
	}

	public double getTest4() {
		return test4;
	}

	public void setTest4(double test4) {
		this.test4 = test4;
	}

	public Double getTest5() {
		return test5;
	}

	public void setTest5(Double test5) {
		this.test5 = test5;
	}

	public Integer getTest6() {
		return test6;
	}

	public void setTest6(Integer test6) {
		this.test6 = test6;
	}

	public String getTest7() {
		return test7;
	}

	public void setTest7(String test7) {
		this.test7 = test7;
	}
	
}
