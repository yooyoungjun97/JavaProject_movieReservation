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
				System.out.println("�α��� ����");	
				MemberVO loginUser = memberservice.getMember(request.get("member_id"));
				LoginUserSession.setLoginUser(loginUser);
				break;
			case 1:
				System.out.println("���̵� �������� �ʽ��ϴ�.");
				memberlogin();
				break;
				
			case 2:
				System.out.println("�н����尡 ��ġ���� �ʽ��ϴ�.");
				memberlogin();
				break;
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���� ��ַ� �α����� �Ұ����մϴ�.");
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

	

	// ���� List�� �־ �Ǵ°���,,, void�� �ϸ� �ٽ� ������ �ؾ� �ϴ���
	public void memberticketsearch() {
		Map<String, String> controllerRequest = MemTkView.TicketSearch();
		
		try {
			ticketservice.getTicketList(controllerRequest.get("tn"),controllerRequest.get("ticket_num"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// ���� List�� �־ �Ǵ°���,,, void�� �ϸ� �ٽ� ������ �ؾ� �ϴ���
	public List memberpointsearch() {
		Map<String, String> controllerRequest = view.PointSearch();

		try {
			memberservice.getMemberList(controllerRequest.get("mpt"),controllerRequest.get("member_point"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ���� List�� �־ �Ǵ°���,,, void�� �ϸ� �ٽ� ������ �ؾ� �ϴ���
	public void membermovieinfo() {
		Map<String, String> controllerRequest = view.MovieInfo();

		try {
			movieservice.getMovieList(controllerRequest.get("mt"),controllerRequest.get("movie_title"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ���� List�� �־ �Ǵ°���,,, void�� �ϸ� �ٽ� ������ �ؾ� �ϴ���
	public void membermoviesearch() {

		Map<String, String> controllerRequest = view.MoiveSearch();

		try {
			movieservice.getMovieList(controllerRequest.get("mt"),controllerRequest.get("movie_title"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ����Ʈ ����� memberVO�� ������ �ͼ� �ؾ��ϴ°���,,
	

}
