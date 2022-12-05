package com.java.view;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.MemberVO;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;

public class JoinMemeber {

	public Map<String, MemberVO> nonregist() {
		String member_id;
		String pwd;
		String member_name;
		String phone;
		Scanner scan = new Scanner(System.in);
		Map<String, MemberVO> request = new HashMap<String, MemberVO>();
		System.out.println("**********************************************");
		System.out.println("*                                            *");
		System.out.println("*                   회원가입                                       *");
		System.out.println("*                                            *");
		System.out.println("**********************************************");
		System.out.print("아이디 : ");
		member_id = scan.nextLine();
		System.out.print("패스워드 : ");
		pwd = scan.nextLine();
		System.out.print("이름 : ");
		member_name = scan.nextLine();
		System.out.print("전화번호 : ");
		phone = scan.nextLine();

		MemberVO memberVO = new MemberVO();

		memberVO.setMember_id(member_id);
		memberVO.setMember_pwd(pwd);
		memberVO.setMember_name(member_name);
		memberVO.setMember_phone_num(phone);
		request.put("JoinMember", memberVO);

		return request;

	}

	public void list() {
	}

	public void checkBuyerID(String id) throws SQLException {
		MemberService memberservice = new MemberServiceImpl();
		memberservice.checkID(id);
	}
	public void regist() {}
	public void modify() {}
	public void search() {}
	public void checkID() {} 
}