package com.hospital.dto;

public class HospitalVO {
	private String id;
	private String pw;
	private String name;
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer gender;
	private String phone;
	private String email1;
	private String email2;
	private String lev;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	
	@Override
	public String toString() {
		return "HospitalVO [id=" + id + ", pw=" + pw + ", name=" + name + ", year=" + year + ", month=" + month
				+ ", day=" + day + ", gender=" + gender + ", phone=" + phone + ", email1=" + email1 + ", email2="
				+ email2 + ", lev=" + lev + "]";
	}

}
