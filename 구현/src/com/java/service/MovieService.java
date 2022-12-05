package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.MovieVO;

public interface MovieService {

	
	List<MovieVO> getMovieList(String title)throws SQLException;
	List<MovieVO> getMovieListByTheater(String theater_identical_number)throws SQLException;
	
	MovieVO getMovieByMovie_identical_number(String movie_identical_number)throws SQLException;

	
	void regist(MovieVO movie)throws SQLException;
	
	
    void remove(String movie_identical_number)throws SQLException;
    
    void modify(MovieVO movie)throws SQLException;
    
    

	

}
