package com.siwei.frame.common.utils.vo;

import com.siwei.frame.common.utils.entity.BaseEntityVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(value = "日志VO")
public class LogVO extends BaseEntityVO {
	
	private String tableName;

	@ApiModelProperty(value = "起始日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate;
	
	@ApiModelProperty(value = "截至日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	private Integer operatorId;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
}
