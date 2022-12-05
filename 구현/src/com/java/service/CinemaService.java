package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.CinemaVO;
import com.java.dto.TheaterVO;


public interface CinemaService {
		
	List<CinemaVO> getCinemaList(String cinema_name)throws SQLException;
	
	CinemaVO getCinema(String cinema_identical_number)throws SQLException;
	
	void regist(CinemaVO cinema)throws SQLException;
	
	void modify(CinemaVO cinema)throws SQLException;
	
	void remove(String cinema_identical_number)throws SQLException;	

}
