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
		System.out.println("*            무빙무비에 오신걸 환영합니다.           *");
		System.out.println("*                                            *");
		System.out.println("*           1.회원가입  2.로그인 선택  3.종료                *");
		System.out.println("*                                            *");
		System.out.println("**********************************************");
		System.out.print("메뉴를 선택하세요.");
		request.put("menu", scann.nextLine());
		
		return request;
	}
	
	
	
	
}
