package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.MemberVO;

public interface MemberDAO {

	

	

	List<MemberVO> selectSearchMemberList(String searchType, String keyword) throws SQLException;
	

	void insertMember(MemberVO member) throws SQLException;

	void updateMember(MemberVO member) throws SQLException;

	void deleteMember(String member_phone_num) throws SQLException;
	
	MemberVO selectMemberByPhoneNum(String member_phone_num) throws SQLException;
	MemberVO selectMemberById(String id) throws SQLException;



	



}
