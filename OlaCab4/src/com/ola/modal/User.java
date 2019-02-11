package com.ola.modal;

public class User {
	private String userName;
	private String userId;
	private long phone;
	private String location;
	private float wallet;
	
	
	
	public User(String userId) {
		super();
		this.userId = userId;
	}
	public User(String userName, String userId, long phone, String location, float wallet) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.phone = phone;
		this.location = location;
		this.wallet = wallet;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getWallet() {
		return wallet;
	}
	public void setWallet(float wallet) {
		this.wallet = wallet;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", phone=" + phone + ", location=" + location
				+ ", wallet=" + wallet + "]";
	}
	

}
