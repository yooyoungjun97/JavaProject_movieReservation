package com.java.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonMemberLogin {

	public Map<String, String> nonlogin() {
		Scanner scan = new Scanner(System.in);
		String member_name ="";
		String member_phone_num ="";
		Map<String, String> request = new HashMap<String, String>();

		System.out.println("**********************************************");
		System.out.println("*                                            *");
		System.out.println("*              ��ȸ���α��� ȭ���Դϴ�                             *");
		System.out.println("*                                            *");
		System.out.println("**********************************************");

		System.out.println("�̸��� �Է��ϼ��� :");
		member_name = scan.nextLine();
		System.out.println("�ڵ��� ��ȣ�� �Է��ϼ��� :");
		member_phone_num = scan.nextLine();

		request.put("NonMemberName", member_name);
		request.put("NonMemberPhone", member_phone_num);

		return request;

	}

}
