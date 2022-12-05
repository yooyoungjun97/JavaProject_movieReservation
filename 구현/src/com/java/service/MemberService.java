package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.ManagerVO;
import com.java.dto.MemberVO;

public interface MemberService {
	
	
	int login(String member_id, String member_pwd) throws SQLException;
	int nonlogin(String member_name, String member_phone_num)throws SQLException;
	
	
	List<MemberVO> getMemberList(String keyword, String searchType)throws SQLException;
	
	
	List<ManagerVO> getTManagerList(String keyword, String searchType) throws SQLException;
	
	//��
	MemberVO getMember(String member_phone_num)throws SQLException;
	
	
	void regist(MemberVO member)throws SQLException;
	
	
	void modify(MemberVO member)throws SQLException;
	
	void remove(String member_phone_num)throws SQLException;
	
	
	int checkID(String member_phone_num)throws SQLException;

	
	
	
	
}













