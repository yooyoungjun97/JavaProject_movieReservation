package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.CinemaVO;
import com.java.dto.ManagerVO;
import com.java.dto.MemberVO;
import com.java.dto.TheaterVO;

public interface ManagerService {
	
	

	int managerlogin(String manager_code, String manager_pwd) throws SQLException;

	
	List<ManagerVO> getManagerList(String searchType, String keyword ) throws SQLException;

	
	ManagerVO getManager(String manager_code) throws SQLException;

	MemberVO getMember(String member_phone_num)throws SQLException;
	
	void regist(ManagerVO manager) throws SQLException;

	
	void modify(ManagerVO manager) throws SQLException;

	
	void remove(String manager_code) throws SQLException;
	
	
	
	

	




	
	

}
