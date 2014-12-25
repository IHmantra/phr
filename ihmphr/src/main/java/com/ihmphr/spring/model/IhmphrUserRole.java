package com.ihmphr.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_role_xface" , uniqueConstraints=@UniqueConstraint (columnNames = {"user_id","user_role_id"}) )
public class IhmphrUserRole {
	
	@Id
	@Column(name="urx_id")
	private Integer urxId ; 
	
	/*
	@Column(name="user_id")
	private String userId ;*/
	
	
	@Column(name="user_role_id")
	private String userRoleId  ;
	
	@Column(name="record_disable_flg")
	private String disableFlg;
	
	
	@Column(name="record_created_by")
	private String createdBy;
	
	@Column(name="record_updated_by")
	private String updatedBy;
	
	@Column(name="record_created_on")
	private Date createDate;
	
	@Column(name="record_updated_on")
	private Date updateDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private IhmphrUser user;
	
	
	public IhmphrUserRole() {
		super();
	}

    /* 
	public IhmphrUserRole(String userId, String userRoleId) {
		super();
		this.userId = userId;
		this.userRoleId = userRoleId;
	}*/



	public Integer getUrxId() {
		return urxId;
	}


	public void setUrxId(Integer urxId) {
		this.urxId = urxId;
	}

    /*
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}*/


    
	public String getUserRoleId() {
		return userRoleId;
	}



	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}



	public String getDisableFlg() {
		return disableFlg;
	}



	public void setDisableFlg(String disableFlg) {
		this.disableFlg = disableFlg;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public Date getUpdateDate() {
		return updateDate;
	}



	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public IhmphrUser getUser() {
		return user;
	}

	public void setUser(IhmphrUser user) {
		this.user = user;
	}

}
