package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dao.CinemaDAO;
import com.java.dao.CinemaDAOImpl;
import com.java.dao.TheaterDAO;
import com.java.dao.TheaterDAOImpl;
import com.java.dto.CinemaVO;
import com.java.dto.TheaterVO;
import com.java.util.IdenticalNumberGenerator;

public class CinemaServiceImpl implements CinemaService {

	private CinemaDAO cinemaDAO = new CinemaDAOImpl();
	private TheaterDAO theaterDAO = new TheaterDAOImpl();

	@Override
	public List<CinemaVO> getCinemaList(String cinema_name) throws SQLException {
		List<CinemaVO> cinemaList = cinemaDAO.selectSearchCinemaList(cinema_name);
		
		if(cinemaList !=null)for(CinemaVO cinema : cinemaList) {
			List<TheaterVO> theaterList = theaterDAO.selectSearchTheaterList(cinema.getCinema_identical_number());
			cinema.setTheater(theaterList);
		}
		
		return cinemaList;
	}

	@Override
	public CinemaVO getCinema(String cinema_identical_number) throws SQLException {
		CinemaVO cinema = cinemaDAO.selectCinemaByCinema_identical_number(cinema_identical_number);
		if(cinema!=null) {
			List<TheaterVO> theaterList = theaterDAO.selectSearchTheaterList(cinema.getCinema_identical_number());
			cinema.setTheater(theaterList);
		}
		
		return cinema;
	}

	@Override
	public void regist(CinemaVO cinema) throws SQLException {
		cinema.setCinema_identical_number(IdenticalNumberGenerator.getIdenticalNumber());
		cinemaDAO.insertCinema(cinema);

	}

	@Override
	public void modify(CinemaVO cinema) throws SQLException {
		cinemaDAO.updateCinema(cinema);

	}

	@Override
	public void remove(String cinema_identical_number) throws SQLException {
		cinemaDAO.deleteCinema(cinema_identical_number);

	}

	


}
