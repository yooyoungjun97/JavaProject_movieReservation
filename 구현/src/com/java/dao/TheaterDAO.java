package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.MovieVO;
import com.java.dto.TheaterVO;

public interface TheaterDAO {

	List<TheaterVO> selectSearchTheaterList(String cinema_identical_number) throws SQLException;

	void insertTheater(TheaterVO theater) throws SQLException;

	void updateTheater(TheaterVO theater) throws SQLException;

	void deleteTheater(String theater_identical_number) throws SQLException;
	
	TheaterVO selectTheaterByTheaterIdenticalNumber(String theater_identical_number) throws SQLException;

}
