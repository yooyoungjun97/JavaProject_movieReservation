package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.datasource.DataSource;
import com.java.dto.CinemaVO;
import com.java.dto.TheaterVO;

public class CinemaDAOImpl implements CinemaDAO {

	private DataSource dataSource = DataSource.getInstance();

	private List<CinemaVO> getCinemaList(ResultSet rs) throws SQLException {
		CinemaVO cinema = null;
		List<CinemaVO> cinemaList = new ArrayList<CinemaVO>();
		while (rs.next()) {

			cinema = new CinemaVO();
			cinema.setCinema_identical_number(rs.getString("cinema_identical_number"));
			cinema.setCinema_name(rs.getString("cinema_name"));
			cinema.setCinema_branch(rs.getString("cinema_branch"));
			cinema.setCinema_address(rs.getString("cinema_address"));
			cinema.setCinema_telephone(rs.getString("cinema_telephone"));

			cinemaList.add(cinema);
		}

		return cinemaList;
	}

	@Override
	public List<CinemaVO> selectSearchCinemaList(String cinema_name) throws SQLException {
		Connection conn = dataSource.getConnection();

		Statement stmt = conn.createStatement();
		String sql = "select * from cinema where cinema_name like '%'||'" + cinema_name + "'||'%'";

		ResultSet rs = stmt.executeQuery(sql);

		List<CinemaVO> cinemaList = getCinemaList(rs);

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();

		return cinemaList;
	}

	@Override
	public CinemaVO selectCinemaByCinema_identical_number(String cinema_identical_number) throws SQLException {
		Connection conn = dataSource.getConnection();

		String sql = "select * from cinema where Cinema_identical_number = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cinema_identical_number);

		ResultSet rs = pstmt.executeQuery();

		List<CinemaVO> cinemaList = getCinemaList(rs);
		CinemaVO cinema = cinemaList.size() > 0 ? cinemaList.get(0) : null;

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return cinema;

	}

	@Override
	public void insertCinema(CinemaVO cinema) throws SQLException {

		Connection conn = dataSource.getConnection();
		String sql = "insert into "
				+ "cinema( cinema_identical_number, cinema_name, cinema_branch, cinema_address, cinema_telephone) "
				+ "values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cinema.getCinema_identical_number());
		pstmt.setString(2, cinema.getCinema_name());
		pstmt.setString(3, cinema.getCinema_branch());
		pstmt.setString(4, cinema.getCinema_address());
		pstmt.setString(5, cinema.getCinema_telephone());

		pstmt.executeUpdate();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

	}

	@Override
	public void updateCinema(CinemaVO cinema) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "update cinema" + " set " + " cinema_name=?,cinema_branch=?,cinema_address=?,"
				+ " cinema_telephone=? ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cinema.getCinema_name());
		pstmt.setString(2, cinema.getCinema_branch());
		pstmt.setString(3, cinema.getCinema_address());
		pstmt.setString(4, cinema.getCinema_telephone());

		pstmt.executeUpdate();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public void deleteCinema(String cinema_identical_number) throws SQLException {

		Connection conn = dataSource.getConnection();

		String sql = "delete from cinema where cinema_identical_number=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cinema_identical_number);
		pstmt.executeUpdate();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

	}



	private List<TheaterVO> getTheaterList(ResultSet rs) throws SQLException {
		TheaterVO theater = null;
		List<TheaterVO> theaterList = new ArrayList<TheaterVO>();
		while (rs.next()) {

			theater = new TheaterVO();
			theater.setTheater_identical_number(rs.getString("theater_identical_number"));
			theater.setTheater_location(rs.getString("theater_location"));

			theater.setTheater_name(rs.getString("theater_name"));
			theater.setTheater_starttime(rs.getDate("theater_starttime"));

			theaterList.add(theater);
		}

		return theaterList;

	}

}
