package com.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.datasource.DataSource;
import com.java.dto.MovieVO;
import com.java.dto.TheaterVO;

public class TheaterDAOImpl implements TheaterDAO {

	
	private DataSource dataSource = DataSource.getInstance();
	
	
	private List<TheaterVO> getTheaterList(ResultSet rs) throws SQLException {
		TheaterVO theater = null;
		List<TheaterVO> theaterList = new ArrayList<TheaterVO>();
		while (rs.next()) {

			theater = new TheaterVO();
			theater.setTheater_identical_number(rs.getString("theater_identical_number"));
			theater.setTheater_location(rs.getString("theater_location"));
			theater.setTheater_seat_row(rs.getString("theater_seat_row"));
			theater.setTheater_seat_col(rs.getString("theater_seat_col"));
			theater.setTheater_name(rs.getString("theater_name"));
			theater.setTheater_starttime(rs.getDate("theater_starttime"));
			
			
			
			theaterList.add(theater);
		}

		return theaterList;
}
	@Override
	public List<TheaterVO> selectSearchTheaterList(String cinema_identical_number) throws SQLException{
		Connection conn = dataSource.getConnection();

		String sql = "select * from theater ";
		ResultSet rs = null;
		if(!cinema_identical_number.isEmpty()) {
			sql+=" where cinema_identical_number =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cinema_identical_number);
			 rs= pstmt.executeQuery();
		}else {
			Statement stmt = conn.createStatement();
			rs =stmt.executeQuery(sql); 
		}


		List<TheaterVO> theaterList = getTheaterList(rs);
		
		if(rs!=null) rs.close();
		if(conn!=null) conn.close();
		
		return theaterList;
	}
	@Override
	public TheaterVO selectTheaterByTheaterIdenticalNumber(String theater_identical_number) throws SQLException {
		
		Connection conn = dataSource.getConnection();
		
		String sql = "select * from theater where theater_identical_number = ?";		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, theater_identical_number);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<TheaterVO> theaterList = getTheaterList(rs);
		TheaterVO theater = theaterList.size() > 0 ? theaterList.get(0):null;
		
		
		if(rs!=null) rs.close();		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
		return theater;
	}

	@Override
	public void insertTheater(TheaterVO theater) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "insert into " 
				   + "Theater( theater_identical_number, theater_location, theater_person_info, theater_name, theater_starttime) "  
				   + "values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,theater.getTheater_identical_number());
		pstmt.setString(2,theater.getTheater_location());
		pstmt.setString(3,theater.getTheater_name());
		pstmt.setDate(4,(Date) theater.getTheater_starttime());
		
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

	@Override
	public void updateTheater(TheaterVO theater) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "update theater" 
					+" set " 
				    +" theater_location=?, theater_person_info=?, theater_name=?,"  
				    +" theater_starttime=? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,theater.getTheater_location());
		pstmt.setString(2,theater.getTheater_name());
		pstmt.setDate(3,(Date) theater.getTheater_starttime());
		
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();

	}

	@Override
	public void deleteTheater(String theater_identical_number) throws SQLException {
        
		Connection conn = dataSource.getConnection();
		
		String sql = "delete from cinema where theater_identical_number=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, theater_identical_number);
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();

	}


}
