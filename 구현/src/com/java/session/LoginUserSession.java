package com.java.session;

import com.java.dto.MemberVO;

public class LoginUserSession {
	
	private static MemberVO loginUser;
	private LoginUserSession() {}
	
	public static MemberVO getLoginUser() {
		return loginUser;
	}
	public static void setLoginUser(MemberVO loginUser) {
		LoginUserSession.loginUser = loginUser;
	}
	
}
