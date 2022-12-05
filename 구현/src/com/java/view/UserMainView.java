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
		System.out.println("*                                 회원 예약화면                                                                        *");
		System.out.println("*                                                                                 *");
		System.out.println("*                        1. 영화 예매  2.예매내역 조회   3.종료                                                     *");
		System.out.println("***********************************************************************************");
		
		System.out.print("메뉴를 선택하세요.");
		request.put("menu", scann.nextLine());
		
		return request;
	}
}
