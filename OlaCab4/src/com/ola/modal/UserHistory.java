package com.ola.modal;

import java.util.Date;

public class UserHistory {
	private String userId;
	private String cabName;
	private Date time;

	public UserHistory(String userId, String cabName, Date time) {
		super();
		this.userId = userId;
		this.cabName = cabName;
		this.time = time;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCabName() {
		return cabName;
	}

	public void setCabName(String cabName) {
		this.cabName = cabName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "UserHistory [userId=" + userId + ", cabName=" + cabName + ", time=" + time + "]";
	}

}
