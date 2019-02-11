package com.ola.modal;

public class Cab {
	private String cabName;
	private String cabNumber;
	private String driverName;
	private long phone;
	private String city;
	private boolean available;
	
	 
	
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cab(String cabName, String cabNumber, String driverName, long phone, String city, boolean available) {
		super();
		this.cabName = cabName;
		this.cabNumber = cabNumber;
		this.driverName = driverName;
		this.phone = phone;
		this.city = city;
		this.available = available;
	}
	public String getCabName() {
		return cabName;
	}
	public void setCabName(String cabName) {
		this.cabName = cabName;
	}
	public String getCabNumber() {
		return cabNumber;
	}
	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Cab [cabName=" + cabName + ", cabNumber=" + cabNumber + ", driverName=" + driverName + ", phone="
				+ phone + ", city=" + city + ", available=" + available + "]";
	}
	

}
