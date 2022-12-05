package com.java.dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

import com.java.dto.CinemaVO;
import com.java.dto.TheaterVO;

public interface CinemaDAO {
	
    List<CinemaVO> selectSearchCinemaList(String keyword) throws SQLException;
	
    CinemaVO selectCinemaByCinema_identical_number(String cinema_identical_number) throws SQLException;
	
	void insertCinema(CinemaVO cinema)throws SQLException;
	
	void updateCinema(CinemaVO cinema)throws SQLException;
	
	void deleteCinema(String cinema_identical_number)throws SQLException;
		
}
