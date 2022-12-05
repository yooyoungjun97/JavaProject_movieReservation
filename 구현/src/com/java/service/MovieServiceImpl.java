package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dao.MovieDAO;
import com.java.dao.MovieDAOImpl;
import com.java.dto.MemberVO;
import com.java.dto.MovieVO;
import com.java.util.IdenticalNumberGenerator;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO = new MovieDAOImpl();

	@Override
	public List<MovieVO> getMovieList(String title) throws SQLException {
		List<MovieVO> movieList = movieDAO.selectSearchMovieList(title);
		return movieList;
	}

	@Override
	public List<MovieVO> getMovieListByTheater(String theater_identical_number) throws SQLException {
		List<MovieVO> movieList = movieDAO.selectMovieListByTheater(theater_identical_number);
		return movieList;
	}

	@Override
	public MovieVO getMovieByMovie_identical_number(String movie_identical_number) throws SQLException {
		MovieVO movie = movieDAO.selectMovieByMovie_identical_number(movie_identical_number);

		return movie;

	}

	@Override
	public void regist(MovieVO movie) throws SQLException {
		movie.setMovie_identical_number(IdenticalNumberGenerator.getIdenticalNumber());
		movieDAO.insertMovie(movie);

	}
	
	@Override
	public void remove(String movie_identical_number) throws SQLException {
		movieDAO.deleteMovie(movie_identical_number);
	}

	@Override
	public void modify(MovieVO movie) throws SQLException {
		movieDAO.updateMovie(movie);
	}

	
}
