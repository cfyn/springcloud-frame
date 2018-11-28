package com.siwei.frame.common.utils.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.siwei.frame.common.utils.helper.groups.UpdateValidGroup;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Description 基础VO对象
 * @author linxiunan
 * @date 2018年10月18日
 */
public abstract class BaseEntityVO {

	@NotNull(message = "所需唯一标识不能为空", groups = {UpdateValidGroup.class})
	public Integer id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date createdTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date lastModifiedTime;
	
	// 是否启用，默认启用
	public Boolean enabled;
	
	// 是否已删除，默认未删除
	public Boolean deleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
