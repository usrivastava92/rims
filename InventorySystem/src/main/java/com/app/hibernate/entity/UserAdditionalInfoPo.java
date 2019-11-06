package com.app.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.hibernate.core.entities.BaseEntity;

@Entity
@Table(name = "USER_ADDITIONAL_INFO")
public class UserAdditionalInfoPo extends BaseEntity {

	private static final long serialVersionUID = -3788850886108135694L;

	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "PROFILE_IMAGE_LINK",columnDefinition = "VARCHAR(500)")
	private String profileImageLink;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getProfileImageLink() {
		return profileImageLink;
	}

	public void setProfileImageLink(String profileImageLink) {
		this.profileImageLink = profileImageLink;
	}

}
