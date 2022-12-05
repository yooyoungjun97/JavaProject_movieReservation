package com.java.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.java.dto.MemberVO;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;
import com.java.service.MovieService;
import com.java.service.MovieServiceImpl;
import com.java.service.ReservationService;
import com.java.service.ReservationServiceImpl;
import com.java.session.LoginUserSession;
import com.java.view.MainView;
import com.java.view.MemberView;
import com.java.view.ReservationView;

public class MemberController {

	private MemberService memberservice = new MemberServiceImpl();
	private MovieService movieservice = new MovieServiceImpl();
	private MemberView memberview = new MemberView();

	public void memberlogin() {
		int result = -1;
		Map<String, String> request = memberview.login();

		try {
			result = memberservice.login(request.get("member_id"), request.get("member_pwd"));

			switch (result) {
			case 0:
				System.out.println("로그인 성공");	
				MemberVO loginUser = memberservice.getMember(request.get("member_id"));
				LoginUserSession.setLoginUser(loginUser);
				break;
			case 1:
				System.out.println("아이디가 존재하지 않습니다.");
				memberlogin();
				break;
				
			case 2:
				System.out.println("패스워드가 일치하지 않습니다.");
				memberlogin();
				break;
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("서비스 장애로 로그인이 불가능합니다.");
			return;

		}

	}

	public void memberregist() {

		Map<String, MemberVO> controllerRequest = memberview.regist();

		try {
			memberservice.regist(controllerRequest.get("member"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	// 질문 List를 넣어도 되는건지,,, void로 하면 다시 선언을 해야 하는지
	public void memberticketsearch() {
		Map<String, String> controllerRequest = MemTkView.TicketSearch();
		
		try {
			ticketservice.getTicketList(controllerRequest.get("tn"),controllerRequest.get("ticket_num"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// 질문 List를 넣어도 되는건지,,, void로 하면 다시 선언을 해야 하는지
	public List memberpointsearch() {
		Map<String, String> controllerRequest = view.PointSearch();

		try {
			memberservice.getMemberList(controllerRequest.get("mpt"),controllerRequest.get("member_point"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 질문 List를 넣어도 되는건지,,, void로 하면 다시 선언을 해야 하는지
	public void membermovieinfo() {
		Map<String, String> controllerRequest = view.MovieInfo();

		try {
			movieservice.getMovieList(controllerRequest.get("mt"),controllerRequest.get("movie_title"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 질문 List를 넣어도 되는건지,,, void로 하면 다시 선언을 해야 하는지
	public void membermoviesearch() {

		Map<String, String> controllerRequest = view.MoiveSearch();

		try {
			movieservice.getMovieList(controllerRequest.get("mt"),controllerRequest.get("movie_title"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 포인트 등록은 memberVO를 가지고 와서 해야하는건지,,
	

}
