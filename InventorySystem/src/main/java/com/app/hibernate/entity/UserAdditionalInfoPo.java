package com.app.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ADDITIONAL_INFO")
public class UserAdditionalInfoPo extends BaseEntity {

	private static final long serialVersionUID = -3788850886108135694L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ADD_INFO_GEN")
	@SequenceGenerator(name = "USER_ADD_INFO_GEN", sequenceName = "USER_ADD_INFO_SEQ", initialValue = 1)
	private long id;
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "PROFILE_IMAGE_LINK")
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

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "UserAdditionalInfoPo [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", profileImageLink=" + profileImageLink + "]";
	}

}
