package com.myo2o.entity;

import java.util.Date;

public class Area {
	/**
	 * 这里所有都用引用类型而不用基础类型的原因
	 * 因为如果是基础类型的话，如果是空值他会给自动设置默认值
	 */
    
	private Long areaId;//id
	private String areaName;//地区名
	private String areaDesc;
	private Integer priority;//权重
	private Date createTime;//创建时间
	private Date lastEditTime;//更新时间

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaDesc() {
		return areaDesc;
	}

	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

}
