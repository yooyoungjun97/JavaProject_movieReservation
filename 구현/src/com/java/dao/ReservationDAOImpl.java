package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.datasource.DataSource;
import com.java.dto.MemberVO;
import com.java.dto.ReservationVO;

public class ReservationDAOImpl implements ReservationDAO {

	private DataSource dataSource = DataSource.getInstance();

	private List<ReservationVO> getReservationList(ResultSet rs) throws SQLException {
		ReservationVO reservation = null;
		List<ReservationVO> reservationList = new ArrayList<ReservationVO>();
		while (rs.next()) {

			reservation = new ReservationVO();
			reservation.setReservation_number(rs.getString("reservation_number"));
			reservation.setReservation_date(rs.getDate("reservation_date"));
			reservation.setCinema_identical_number(rs.getString("cinema_identical_number"));
			reservation.setMember_phone_num(rs.getString("member_phone_num"));
			reservation.setMovie_identical_number(rs.getString("movie_identical_number"));
			reservation.setReservation_payment(rs.getString("reservation_payment"));
			reservation.setReservation_regdate(rs.getDate("reservation_regdate"));
			reservation.setTheater_identical_number(rs.getString("theater_identical_number"));

			reservationList.add(reservation);
		}

		return reservationList;
	}

	@Override
	public List<ReservationVO> selectSearchReservationList(MemberVO member, String reservation) throws SQLException {
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "select * from reservation where 1 = 1   ";
		if (member != null)
			sql += " and member_phone_num = "+member.getMember_phone_num();

		if (reservation != null && !reservation.isEmpty())
			sql += " and regDate between to_date('"
					+reservation+"','yyyy-MM-DD 00:00:00') and to_date('"
					+reservation+"','yyyy-MM-DD 24:00:00')";
		
		
		ResultSet rs = stmt.executeQuery(sql);

		List<ReservationVO> reservationList = getReservationList(rs);

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();

		return reservationList;
	}

	@Override
	public ReservationVO selectReservationByReservation_number(String reservation_number) throws SQLException {
		Connection conn = dataSource.getConnection();

		String sql = "select * from reservation where reservation_number = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reservation_number);

		ResultSet rs = pstmt.executeQuery();

		List<ReservationVO> reservationList = getReservationList(rs);
		ReservationVO reservation = reservationList.size() > 0 ? reservationList.get(0) : null;

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return reservation;
	}

	@Override
	public void insertReservation(ReservationVO reservation) throws SQLException {

		Connection conn = dataSource.getConnection();
		String sql = "insert into " + "reservation(" + "reservation_number, " + "reservation_date, "
				+  "member_phone_num, " + "theater_identical_number, "
				+ "cinema_identical_number, " + "movie_identical_number, " + "reservation_payment)"
				+ " values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reservation.getReservation_number());
		pstmt.setDate(2, new java.sql.Date(reservation.getReservation_date().getTime()));
		pstmt.setString(3, reservation.getMember_phone_num());
		pstmt.setString(4, reservation.getTheater_identical_number());
		pstmt.setString(5, reservation.getCinema_identical_number());
		pstmt.setString(6, reservation.getMovie_identical_number());
		pstmt.setString(7, reservation.getReservation_payment());

		pstmt.executeUpdate();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public void updateReservation(ReservationVO reservation) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "update reservation" + " set " + " reservation_number=?, " + "reservation_date=?, "
				+  "member_phone_num=?," + "theater_identical_number=?,"
				+ "cinema_identical_number=?," + "movie_identical_number=?," + "reservation_payment=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reservation.getReservation_number());
		pstmt.setDate(2, new java.sql.Date(reservation.getReservation_date().getTime()));
		pstmt.setString(3, reservation.getMember_phone_num());
		pstmt.setString(4, reservation.getTheater_identical_number());
		pstmt.setString(5, reservation.getCinema_identical_number());
		pstmt.setString(6, reservation.getMovie_identical_number());
		pstmt.setString(7, reservation.getReservation_payment());
		pstmt.executeUpdate();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

	}

	@Override
	public void deleteReservation(String reservation_number) throws SQLException {

		Connection conn = dataSource.getConnection();

		String sql = "delete from Reservation where reservation_number =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reservation_number);
		pstmt.executeUpdate();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

	}

}
