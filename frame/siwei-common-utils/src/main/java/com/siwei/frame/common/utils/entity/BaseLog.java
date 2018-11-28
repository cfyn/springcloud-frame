package com.siwei.frame.common.utils.entity;

public class BaseLog extends BaseEntity {

	private String ip;
	
	private String operation;
	
	private Integer entityId;
	
	private String log;
	
	private String changeJson;
	
	private String tableName;
	
	private Integer operatorId;
	
	private String nickName;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getChangeJson() {
		return changeJson;
	}

	public void setChangeJson(String changeJson) {
		this.changeJson = changeJson;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
