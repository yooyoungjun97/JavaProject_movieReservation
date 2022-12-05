package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.TheaterVO;

public interface TheaterService {

	
	
		List<TheaterVO> getTheaterList(String cinema_identical_number)throws SQLException;
		
		TheaterVO getTheater(String theater_identical_number)throws SQLException;
		
		void regist(TheaterVO theater)throws SQLException;
		
		void modify(TheaterVO theater)throws SQLException;
		
		void remove(String theater_identical_number)throws SQLException;
				
		
}
