package com.java.view;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class UserMainView {

	public Map<String, String> main(){
		Scanner scann = new Scanner(System.in);
		
		Map<String,String> request = new HashMap<String,String>();
		
		System.out.println("***********************************************************************************");
		System.out.println("*                                                                                 *");
		System.out.println("*                                 ȸ�� ����ȭ��                                                                        *");
		System.out.println("*                                                                                 *");
		System.out.println("*                        1. ��ȭ ����  2.���ų��� ��ȸ   3.����                                                     *");
		System.out.println("***********************************************************************************");
		
		System.out.print("�޴��� �����ϼ���.");
		request.put("menu", scann.nextLine());
		
		return request;
	}
}
