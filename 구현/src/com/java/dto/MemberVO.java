package com.java.dto;

public class MemberVO {
	private String member_phone_num;
	private String member_id;
	private String member_pwd;
	private String member_name;
	private int member_point;
	private String member_state;

	public String getMember_state() {
		return member_state;
	}

	public void setMember_state(String member_state) {
		this.member_state = member_state;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getMember_point() {
		return member_point;
	}

	public void setMember_point(int member_point) {
		this.member_point = member_point;
	}

	public String getMember_phone_num() {
		return member_phone_num;
	}

	public void setMember_phone_num(String member_phone_num) {
		this.member_phone_num = member_phone_num;
	}

	@Override
	public String toString() {
		return member_id + "," + member_pwd + "," + member_name + "," + member_point + "," + member_phone_num + ","
				+ member_state + "\n";
	}

}
