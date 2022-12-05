package com.java.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.java.dto.MemberVO;
import com.java.dto.ReservationVO;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;
import com.java.view.MemberView;

public class NonMemberController {

	private MemberService service = new MemberServiceImpl();
	private MemberView view = new MemberView();

	public void nonlogin() {

		int result = -1;

		Map<String, String> request = view.nonlogin();

		try {
			result = service.nonlogin(request.get("member_phone_num"), request.get("member_name"));

			switch (result) {
			case 0:
				System.out.println("로그인 성공");
				view.list();
				break;
			case 1:
				System.out.println("이름이 다릅니다.");
				break;
			case 2:
				System.out.println("이름과 전화번호가 다릅니다.");
				break;

			}

		} catch (SQLException e) {
			System.out.println("서비스장애로 로그인이 불가능합니다.");
		}

	}
	
	
	public void nonregist() {
		
		int result = -1;
		Map<String, String> request = view.SignUp();

		try {
			result = service.nonregist(request.get("member_id"),request.get("member_name"));

			switch (result) {
			case 0:
				System.out.println("회원가입 성공");
				view.list();
				break;
			case 1:
				System.out.println("아이디가 존재합니다.");
				break;

			}

		} catch (SQLException e) {
			System.out.println("서비스장애로 회원가입이 불가능합니다.");
		}

		
	}
	
	public void MemberRegist() {

		Map<String, MemberVO> controllerRequest = view.MemeberRegist();

		try {
			Mservice.regist(controllerRequest.get("member"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void MemberReservationRegist() {

		Map<String, ReservationVO> controllerRequest = view.ReservationRegist();

		try {
			Rservice.regist(controllerRequest.get("reservation"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 질문 List를 넣어도 되는건지,,, void로 하면 다시 선언을 해야 하는지
	public void MemberTicketSearch() {
		Map<String, String> controllerRequest = view.TicketSearch();
		
		try {
			Tservice.getTicketList(keyword, searchType)(controllerRequest.get(""));

		} catch (SQLException e) {
			e.printStackTrace();
		}		

	}

// 질문 List를 넣어도 되는건지,,, void로 하면 다시 선언을 해야 하는지
	public List MemberPointSearch() {
		Map<String, String> controllerRequest = view.PointSearch();

		try {
			Mservice.selectSearchMemberList("mp", "member_point");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 질문 List를 넣어도 되는건지,,, void로 하면 다시 선언을 해야 하는지
	public void MemberMovieInfo() {
		Map<String, String> controllerRequest = view.MovieInfo();

		try {
			Movieservice.selectMovieByMovie_identical_number("");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 질문 List를 넣어도 되는건지,,, void로 하면 다시 선언을 해야 하는지
	public void MemberMovieSearch() {

		Map<String, String> controllerRequest = view.MoiveSearch();

		try {
			Movieservice.selectSearchMemberList("mt", "movie_title");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	


}
