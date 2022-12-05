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
		System.out.println("*            1. ȸ�� �α���   2.����                               *");
		System.out.println("*                                            *");
		System.out.println("**********************************************");
	
		System.out.println("�޴��� �����ϼ���.");
		menu=Integer.parseInt(scann.nextLine());
		
		System.out.print("���̵� : ");
		member_id = scann.nextLine();
		System.out.print("�н����� : ");
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
		System.out.println("*                  ȸ������                                         *");
		System.out.println("*                                            *");
		System.out.println("**********************************************");
		System.out.print("���̵� : ");
		member_id = scann.nextLine();
		System.out.print("�н����� : ");
		member_pwd = scann.nextLine();
		System.out.print("�ڵ�����ȣ(010����) : ");
		member_phone_num = scann.nextLine();
		System.out.print("�̸� : ");
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
 