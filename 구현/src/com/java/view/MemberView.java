package com.java.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.MemberVO;

public class MemberView {
	
	public Map<String, String> login() {
		Scanner scann = new Scanner(System.in);
		String member_id="";
		String member_pwd="";
		int menu=0;
		Map<String,String> request = new HashMap<String,String>();
		System.out.println("**********************************************");
		System.out.println("*                                            *");
		System.out.println("*            1. 회원 로그인   2.종료                               *");
		System.out.println("*                                            *");
		System.out.println("**********************************************");
	
		System.out.println("메뉴를 선택하세요.");
		menu=Integer.parseInt(scann.nextLine());
		
		System.out.print("아이디 : ");
		member_id = scann.nextLine();
		System.out.print("패스워드 : ");
		member_pwd = scann.nextLine();
		
		request.put("member_id", member_id);
		request.put("member_pwd", member_pwd);
		
		return request;
		
	}


	public Map<String, MemberVO> regist() {
		
		Scanner scann = new Scanner(System.in);
		String member_id="";
		String member_pwd="";
		String member_name="";
		String member_phone_num="";
		int member_point=0;
		String member_state="";
		
		Map<String, MemberVO> request = new HashMap<String,MemberVO>();
		System.out.println("**********************************************");
		System.out.println("*                                            *");
		System.out.println("*                  회원가입                                         *");
		System.out.println("*                                            *");
		System.out.println("**********************************************");
		System.out.print("아이디 : ");
		member_id = scann.nextLine();
		System.out.print("패스워드 : ");
		member_pwd = scann.nextLine();
		System.out.print("핸드폰번호(010제외) : ");
		member_phone_num = scann.nextLine();
		System.out.print("이름 : ");
		member_name= scann.nextLine();	
		
		MemberVO membervo = new MemberVO();
		
		membervo.setMember_phone_num(member_phone_num);
		membervo.setMember_id(member_id);
		membervo.setMember_pwd(member_pwd);
		membervo.setMember_name(member_name);	
		request.put("member", membervo);

		
		return request;
		
		
	}

}
 