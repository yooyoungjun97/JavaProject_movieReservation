package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dao.ManagerDAO;
import com.java.dao.ManagerDAOImpl;
import com.java.dao.MemberDAO;
import com.java.dao.MemberDAOImpl;
import com.java.dto.ManagerVO;
import com.java.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO = new MemberDAOImpl();
	private ManagerDAO managerDAO = new ManagerDAOImpl();

	@Override
	public int login(String member_id, String member_pwd) throws SQLException {
		int result = 0;

		MemberVO member = memberDAO.selectMemberById(member_id);
		if (member != null) { 
			if (member_pwd.equals(member.getMember_pwd())) {
				result = 0;
			} else { 
				result = 2;
			}
		} else {
			result = 1;
		}

		return result;
	}

	@Override
	public List<MemberVO> getMemberList(String keyword, String searchType) throws SQLException {
		List<MemberVO> memberList = memberDAO.selectSearchMemberList(searchType, keyword);
		return memberList;
	}

	@Override
	public List<ManagerVO> getTManagerList(String keyword, String searchType) throws SQLException {
		List<ManagerVO> managerList = managerDAO.selectSearchManagerList(searchType, keyword);
		return managerList;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);

	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		memberDAO.updateMember(member);
	}

	@Override
	public void remove(String member_phone_num) throws SQLException {
		memberDAO.deleteMember(member_phone_num);

	}

	@Override
	public int checkID(String member_id) throws SQLException {
		int result = -1;
		MemberVO member = memberDAO.selectMemberById(member_id);

		if (member != null) { // 
			result = 1;
		} else { // 
			result = 0;
		}
		return result;
	}



	@Override
	public int nonlogin(String member_phone_num, String member_name) throws SQLException {

		int result = 0;

		MemberVO member = memberDAO.selectMemberByPhoneNum(member_phone_num);
		if (member != null) { // 
			if (member_name.equals(member.getMember_name())) {
				result = 0;
			} else {

				result = 2;
			}

		} else {
			result = 1;
		}

		return result;
	}


}
