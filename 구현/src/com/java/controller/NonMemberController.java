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
				System.out.println("�α��� ����");
				view.list();
				break;
			case 1:
				System.out.println("�̸��� �ٸ��ϴ�.");
				break;
			case 2:
				System.out.println("�̸��� ��ȭ��ȣ�� �ٸ��ϴ�.");
				break;

			}

		} catch (SQLException e) {
			System.out.println("������ַ� �α����� �Ұ����մϴ�.");
		}

	}
	
	
	public void nonregist() {
		
		int result = -1;
		Map<String, String> request = view.SignUp();

		try {
			result = service.nonregist(request.get("member_id"),request.get("member_name"));

			switch (result) {
			case 0:
				System.out.println("ȸ������ ����");
				view.list();
				break;
			case 1:
				System.out.println("���̵� �����մϴ�.");
				break;

			}

		} catch (SQLException e) {
			System.out.println("������ַ� ȸ�������� �Ұ����մϴ�.");
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

	// ���� List�� �־ �Ǵ°���,,, void�� �ϸ� �ٽ� ������ �ؾ� �ϴ���
	public void MemberTicketSearch() {
		Map<String, String> controllerRequest = view.TicketSearch();
		
		try {
			Tservice.getTicketList(keyword, searchType)(controllerRequest.get(""));

		} catch (SQLException e) {
			e.printStackTrace();
		}		

	}

// ���� List�� �־ �Ǵ°���,,, void�� �ϸ� �ٽ� ������ �ؾ� �ϴ���
	public List MemberPointSearch() {
		Map<String, String> controllerRequest = view.PointSearch();

		try {
			Mservice.selectSearchMemberList("mp", "member_point");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ���� List�� �־ �Ǵ°���,,, void�� �ϸ� �ٽ� ������ �ؾ� �ϴ���
	public void MemberMovieInfo() {
		Map<String, String> controllerRequest = view.MovieInfo();

		try {
			Movieservice.selectMovieByMovie_identical_number("");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ���� List�� �־ �Ǵ°���,,, void�� �ϸ� �ٽ� ������ �ؾ� �ϴ���
	public void MemberMovieSearch() {

		Map<String, String> controllerRequest = view.MoiveSearch();

		try {
			Movieservice.selectSearchMemberList("mt", "movie_title");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	


}
