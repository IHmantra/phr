package com.ihmphr.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name = "user_credential_table")
public class IhmphrUser {

	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="internal_user_id")
	private String internalUserId;
	
	@Column(name="passkey")
	private String passkey;
	
	@Column(name="user_first_name")
	private String firstName;
	
	@Column(name="user_last_name")
	private String lastName;
	
	@Column(name="user_phone_no")
	private String phone;
	
	@Column(name="user_birth_date")
	private Date birthDate;
	
	@Column(name="user_gender")
	private String gender;
	
	@Column(name="user_login_attempt")
	private int loginAttempt;
	
	@Column(name="user_locked_flg")
	private String lockedFlg;
	
	@Column(name="user_active_flg")
	private String activeFlg;
	
	@Column(name="user_activation_date")
	private Date activationDate;
	
	@Column(name="user_expiry_date")
	private Date expiryDate;
	
	@Column(name="password_expiry_date")
	private Date passwordExpiryDate;
		
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
	
	@OneToMany(mappedBy="user")
	private Set<IhmphrUserRole> userRole = new HashSet<IhmphrUserRole>();
	
	public IhmphrUser() {
		super();
	}

	public IhmphrUser(String userId, String passkey, Set<IhmphrUserRole> userRole) {
		super();
		this.userId = userId;
		this.passkey = passkey;
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInternalUserId() {
		return internalUserId;
	}

	public void setInternalUserId(String internalUserId) {
		this.internalUserId = internalUserId;
	}

	public String getPasskey() {
		return passkey;
	}

	public void setPasskey(String passkey) {
		this.passkey = passkey;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public String getLockedFlg() {
		return lockedFlg;
	}

	public void setLockedFlg(String lockedFlg) {
		this.lockedFlg = lockedFlg;
	}

	public String getActiveFlg() {
		return activeFlg;
	}

	public void setActiveFlg(String activeFlg) {
		this.activeFlg = activeFlg;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getPasswordExpiryDate() {
		return passwordExpiryDate;
	}

	public void setPasswordExpiryDate(Date passwordExpiryDate) {
		this.passwordExpiryDate = passwordExpiryDate;
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

	 
	public Set<IhmphrUserRole> getUserRole() {
		System.out.println(" Getting User Roles");
		return userRole;
	}

	public void setUserRole(Set<IhmphrUserRole> userRole) {
		this.userRole = userRole;
	}

	
	
	
	
	
	}
