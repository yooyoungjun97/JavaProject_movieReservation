package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.datasource.DataSource;
import com.java.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private DataSource dataSource = DataSource.getInstance();

	private List<MemberVO> getMemberList(ResultSet rs) throws SQLException {
		MemberVO member = null;
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		while (rs.next()) {
			member = new MemberVO();
			member.setMember_phone_num(rs.getString("member_phone_num"));
			member.setMember_id(rs.getString("member_id"));
			member.setMember_pwd(rs.getString("member_pwd"));
			member.setMember_name(rs.getString("member_name"));
			member.setMember_point(rs.getInt("member_point"));		
			member.setMember_state(rs.getString("member_state"));

			memberList.add(member);

		}
		return memberList;

	}

	@Override
	public List<MemberVO> selectSearchMemberList(String searchType, String keyword) throws SQLException {
		Connection conn = dataSource.getConnection();

		Statement stmt = conn.createStatement();
		String sql = " select * from member where ";
		switch (searchType) {
		case "i":
			sql += "id";
			break;
		case "n":
			sql += "name";
			break;
		case "p":
			sql += "phone";
			break;
		case "e":
			sql += "email";
			break;
		}

		sql += " like '%' ||' " + keyword + "'||''%'";

		ResultSet rs = stmt.executeQuery(sql);

		List<MemberVO> memberList = getMemberList(rs);

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();

		return memberList;
	}
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		Connection conn = dataSource.getConnection();

		String sql = "select * from member where member_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);

		ResultSet rs = pstmt.executeQuery();

		List<MemberVO> memberList = getMemberList(rs);
		MemberVO member = memberList.size() > 0 ? memberList.get(0) : null;

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return member;
	}

	@Override
	public MemberVO selectMemberByPhoneNum(String member_phone_num) throws SQLException {
		Connection conn = dataSource.getConnection();

		String sql = "select * from member where member_phone_num = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,member_phone_num);

		ResultSet rs = pstmt.executeQuery();

		List<MemberVO> memberList = getMemberList(rs);
		MemberVO member = memberList.size() > 0 ? memberList.get(0) : null;

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "insert into" + " member(member_phone_num, member_id, member_pwd, member_name, member_point, member_state) " + "values(?,?,?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMember_phone_num());
		pstmt.setString(2, member.getMember_id());
		pstmt.setString(3, member.getMember_pwd());
		pstmt.setString(4, member.getMember_name());
		pstmt.setInt(5, member.getMember_point());		
		pstmt.setString(6, member.getMember_state());

		pstmt.executeUpdate(); 

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "update member" 
				   + "set" 
				   + "member_phone_num=?, member_id=?, member_pwd=?, member_name=?, member_point=?,  member_state=? ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMember_phone_num());
		pstmt.setString(2, member.getMember_id());
		pstmt.setString(3, member.getMember_pwd());
		pstmt.setString(4, member.getMember_name());
		pstmt.setInt(5, member.getMember_point());	
		pstmt.setString(6, member.getMember_state());

		pstmt.executeUpdate();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

	}

	@Override
	public void deleteMember(String member_phone_num) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "delete from member where member_phone_num =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,member_phone_num);
		pstmt.executeUpdate();
		
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		

	}

	



}
