package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.datasource.DataSource;
import com.java.dto.ManagerVO;
import com.java.dto.MemberVO;

public class ManagerDAOImpl implements ManagerDAO {

	private DataSource dataSource = DataSource.getInstance();

	private List<ManagerVO> getManagerList(ResultSet rs) throws SQLException {
		ManagerVO manager = null;
		List<ManagerVO> managerList = new ArrayList<ManagerVO>();
		while (rs.next()) {

			manager = new ManagerVO();
			manager.setManager_code(rs.getString("manager_code"));
			manager.setManager_pwd(rs.getString("manager_pwd"));
			manager.setManager_name(rs.getString("manager_name"));
			manager.setManager_phone_num(rs.getString("manager_phone_num"));

			managerList.add(manager);
		}

		return managerList;

	}
	

	@Override
	public List<ManagerVO> selectSearchManagerList(String searchType, String keyword) throws SQLException {
		Connection conn = dataSource.getConnection();

		Statement stmt = conn.createStatement();
		String sql = "select * from manager where ";
		switch (searchType) {
		case "mcode": // 아이디
			sql+="manager_code";
			break;
		case "mpwd": // 비밀번호
			sql+="manager_code";
			break;
			
		case "mname": // 이름
			sql+="manager_name";
			break;
		case "mnum": // 전화번호
			sql+="manager_phone_num";
			break;
		}
		
		sql+=" like '%'||'"+keyword+"'||'%'";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		List<ManagerVO> managerList = getManagerList(rs);
	
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
			
			
		return managerList;
	}

	@Override
	public void insertManager(ManagerVO manager) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "insert into " 
				   + "member(manager_code, manager_name, manager_num, manager_phone_num) "  
				   + "values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,manager.getManager_code());
		pstmt.setString(2,manager.getManager_pwd());
		pstmt.setString(3,manager.getManager_name());
		pstmt.setString(4,manager.getManager_phone_num());
		
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	@Override
	public void updateManager(ManagerVO manager) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "update manager" + "manager(manager_code, manager_name, manager_num, manager_phone_num) " + "values(?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,manager.getManager_code());
		pstmt.setString(2,manager.getManager_pwd());
		pstmt.setString(3,manager.getManager_name());
		pstmt.setString(4,manager.getManager_phone_num());
		
		pstmt.executeUpdate();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

	}

	@Override
	public void deleteManager(String manager_code) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "delete from manager where manager_code =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,manager_code);
		pstmt.executeUpdate();
		
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		

	
	}


	@Override
	public ManagerVO selectManagerByCode(String manager_code) throws SQLException {
		Connection conn = dataSource.getConnection();

		String sql = "select * from manager where manager_code = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, manager_code);

		ResultSet rs = pstmt.executeQuery();

		List<ManagerVO> managerList = getManagerList(rs);
		ManagerVO manager = managerList.size() > 0 ? managerList.get(0) : null;

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return manager;
	}

}
