package com.home.socialMember.vo;

public class MemberInfo {
	private String  mi_email, mi_pw, mi_name, mi_birth, mi_phone;
	private int idx;
	private boolean mi_gender, mi_status;
	
	
	public String getMi_email() {
		return mi_email;
	}
	public void setMi_email(String mi_email) {
		this.mi_email = mi_email;
	}
	public String getMi_pw() {
		return mi_pw;
	}
	public void setMi_pw(String mi_pw) {
		this.mi_pw = mi_pw;
	}
	public String getMi_name() {
		return mi_name;
	}
	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}
	public String getMi_birth() {
		return mi_birth;
	}
	public void setMi_birth(String mi_birth) {
		this.mi_birth = mi_birth;
	}
	public String getMi_phone() {
		return mi_phone;
	}
	public void setMi_phone(String mi_phone) {
		this.mi_phone = mi_phone;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public boolean isMi_gender() {
		return mi_gender;
	}
	public void setMi_gender(boolean mi_gender) {
		this.mi_gender = mi_gender;
	}
	public boolean isMi_status() {
		return mi_status;
	}
	public void setMi_status(boolean mi_status) {
		this.mi_status = mi_status;
	}
	
	
}