package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dao.MovieDAO;
import com.java.dao.MovieDAOImpl;
import com.java.dao.TheaterDAO;
import com.java.dao.TheaterDAOImpl;
import com.java.dto.MovieVO;
import com.java.dto.TheaterVO;
import com.java.util.IdenticalNumberGenerator;

public class TheaterServiceImpl implements TheaterService {
	
	private TheaterDAO theaterDAO = new TheaterDAOImpl();
	private MovieDAO movieDAO = new MovieDAOImpl();

	@Override
	public List<TheaterVO> getTheaterList(String cinema_identical_number) throws SQLException {
		List<TheaterVO> theaterList = theaterDAO.selectSearchTheaterList(cinema_identical_number);
		
		if(theaterList !=null) for(TheaterVO theater : theaterList) {
			List<MovieVO> movieList = movieDAO.selectMovieListByTheater(theater.getTheater_identical_number());
			theater.setMovies(movieList);
		}
		return theaterList;
	}

	@Override
	public TheaterVO getTheater(String theater_identical_number) throws SQLException {
		TheaterVO theater = theaterDAO.selectTheaterByTheaterIdenticalNumber(theater_identical_number);
		if(theater !=null) {
			List<MovieVO> movieList =movieDAO.selectMovieListByTheater(theater.getTheater_identical_number());
			theater.setMovies(movieList);
		}
		return theater;
	}

	@Override
	public void regist(TheaterVO theater) throws SQLException {
		theater.setTheater_identical_number(IdenticalNumberGenerator.getIdenticalNumber());
		theaterDAO.insertTheater(theater);
	}

	@Override
	public void modify(TheaterVO theater) throws SQLException {
		 theaterDAO.updateTheater(theater);

	}

	@Override
	public void remove(String theater_identical_number) throws SQLException {
		theaterDAO.deleteTheater(theater_identical_number);
	}



}
