package com.java.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {

	public Map<String, String> main(){
		Scanner scann = new Scanner(System.in);
		
		Map<String,String> request = new HashMap<String,String>();
		
		System.out.println("**********************************************");
		System.out.println("*                                            *");
		System.out.println("*            �������� ���Ű� ȯ���մϴ�.           *");
		System.out.println("*                                            *");
		System.out.println("*           1.ȸ������  2.�α��� ����  3.����                *");
		System.out.println("*                                            *");
		System.out.println("**********************************************");
		System.out.print("�޴��� �����ϼ���.");
		request.put("menu", scann.nextLine());
		
		return request;
	}
	
	
	
	
}
