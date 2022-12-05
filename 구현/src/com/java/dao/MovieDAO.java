package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.MovieVO;

public interface MovieDAO {

    List<MovieVO> selectSearchMovieList(String keyword) throws SQLException;
    List<MovieVO> selectMovieListByTheater(String theater_identical_number) throws SQLException;
	
    MovieVO selectMovieByMovie_identical_number(String movie_identical_number) throws SQLException;
	
	void insertMovie(MovieVO movie)throws SQLException;
	
	void updateMovie(MovieVO movie)throws SQLException;
	
	void deleteMovie(String movie_identical_number)throws SQLException;
	
	
}
