package com.poc.user.bean;

import java.util.List;

public class UnregUser {
	public String id;
	public String emailAddress;
	public String languageCode;
	public String registrationId;
	public String registrationIdGeneratedTime;

	public List<String> projectIds;

	public List<String> getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(List<String> projectIds) {
		this.projectIds = projectIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationIdGeneratedTime() {
		return registrationIdGeneratedTime;
	}

	public void setRegistrationIdGeneratedTime(String registrationIdGeneratedTime) {
		this.registrationIdGeneratedTime = registrationIdGeneratedTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnregUser [id=");
		builder.append(id);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", languageCode=");
		builder.append(languageCode);
		builder.append(", registrationId=");
		builder.append(registrationId);
		builder.append(", registrationIdGeneratedTime=");
		builder.append(registrationIdGeneratedTime);
		builder.append("]");
		return builder.toString();
	}

}
