package com.java.controller;

import java.sql.SQLException;
import java.util.Map;

import com.java.dto.TheaterVO;
import com.java.service.CinemaService;
import com.java.service.CinemaServiceImpl;
import com.java.service.TheaterService;
import com.java.service.TheaterServiceImpl;
import com.java.view.TeaterAdmin;

public class TheaterController {
	
	private CinemaService cinemaService = new CinemaServiceImpl();
	private TheaterService theaterService = new TheaterServiceImpl();
	//private TheaterView view = new TheaterView();
	private TeaterAdmin teateradminview = new TeaterAdmin();
	

	public void Theateregist() throws SQLException {

		Map<String, String> controllerRequest = teateradminview.regist();

		theaterService.regist(controllerRequest.get("theater"));

	}

	public void TheaterMoidfy() {
		
		Map<String, TheaterVO> controllerRequest = teateradminview.modify();

		try {
			theaterService.modify(controllerRequest.get("theater"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void TheaterRemove() {
		Map<String, String> controllerRequest = teateradminview.

		try {
			cinemaService.remove(controllerRequest.remove("theater_identical_number"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
