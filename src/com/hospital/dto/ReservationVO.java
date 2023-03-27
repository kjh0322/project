package com.hospital.dto;

public class ReservationVO {
	private Integer no;
	private String id;
	private String name;
	private Integer gender;
	private Integer year;
	private Integer month;
	private Integer day;
	private String phone;
	private String doctor;
	private Integer rsy;
	private Integer rsm;
	private Integer rsd;
	private Integer rsh;
	private Integer rsmin;
	private String content;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public Integer getRsy() {
		return rsy;
	}
	public void setRsy(Integer rsy) {
		this.rsy = rsy;
	}
	public Integer getRsm() {
		return rsm;
	}
	public void setRsm(Integer rsm) {
		this.rsm = rsm;
	}
	public Integer getRsd() {
		return rsd;
	}
	public void setRsd(Integer rsd) {
		this.rsd = rsd;
	}
	public Integer getRsh() {
		return rsh;
	}
	public void setRsh(Integer rsh) {
		this.rsh = rsh;
	}
	public Integer getRsmin() {
		return rsmin;
	}
	public void setRsmin(Integer rsmin) {
		this.rsmin = rsmin;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ReservationVO [no=" + no + ", id=" + id + ", name=" + name + ", gender=" + gender + ", year=" + year
				+ ", month=" + month + ", day=" + day + ", phone=" + phone + ", doctor=" + doctor + ", rsy=" + rsy
				+ ", rsm=" + rsm + ", rsd=" + rsd + ", rsh=" + rsh + ", rsmin=" + rsmin + ", content=" + content + "]";
	}
		
}