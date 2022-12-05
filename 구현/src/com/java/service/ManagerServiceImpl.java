package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dao.CinemaDAO;
import com.java.dao.CinemaDAOImpl;
import com.java.dao.ManagerDAO;
import com.java.dao.ManagerDAOImpl;
import com.java.dao.MemberDAO;
import com.java.dao.MemberDAOImpl;
import com.java.dao.TheaterDAO;
import com.java.dao.TheaterDAOImpl;
import com.java.dto.ManagerVO;
import com.java.dto.MemberVO;

public class ManagerServiceImpl implements ManagerService {

	private ManagerDAO managerDAO = new ManagerDAOImpl();
	private MemberDAO memberDAO = new MemberDAOImpl();
	private TheaterDAO theaterDAO = new TheaterDAOImpl();
	private CinemaDAO cinemaDAO = new CinemaDAOImpl();

	@Override
	public List<ManagerVO> getManagerList(String searchType, String keyword) throws SQLException {
		List<ManagerVO> managerList = managerDAO.selectSearchManagerList(searchType, keyword);
		return managerList;

	}

	@Override
	public ManagerVO getManager(String manager_code) throws SQLException {
		ManagerVO manager = managerDAO.selectManagerByCode(manager_code);
		return manager;
	}

	@Override
	public void regist(ManagerVO manager) throws SQLException {
		managerDAO.insertManager(manager);

	}

	@Override
	public void modify(ManagerVO manager) throws SQLException {
		managerDAO.updateManager(manager);

	}

	@Override
	public void remove(String manager_code) throws SQLException {
		managerDAO.deleteManager(manager_code);

	}



	@Override
	public int managerlogin(String manager_code, String manager_pwd) throws SQLException {
		int result = 0;

		ManagerVO manager = managerDAO.selectManagerByCode(manager_code);
		if (manager != null) { 
			if (manager_pwd.equals(manager.getManager_code())) {
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
	public MemberVO getMember(String member_phone_num) throws SQLException {
		
		MemberVO member = memberDAO.selectMemberByPhoneNum(member_phone_num);
		
		return member;

		
	}



}
