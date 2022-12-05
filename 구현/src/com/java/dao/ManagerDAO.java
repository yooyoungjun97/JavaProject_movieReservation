package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.ManagerVO;
import com.java.dto.MemberVO;

public interface ManagerDAO{
	
	List<ManagerVO> selectSearchManagerList(String searchType, String keyword) throws SQLException;
	
	ManagerVO selectManagerByCode(String manager_code) throws SQLException;
	
	void insertManager(ManagerVO manager) throws SQLException;
	
	void updateManager(ManagerVO manager) throws SQLException;
	
	void deleteManager(String manager_code) throws SQLException;
	
	

	

}
