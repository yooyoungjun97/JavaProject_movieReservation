package com.java.main;

import java.util.Map;

import com.java.controller.MemberController;
import com.java.controller.ReservationController;
import com.java.dto.ReservationVO;
import com.java.view.MainView;
import com.java.view.ReservationView;
import com.java.view.UserMainView;

public class Main {

	private MemberController memberController = new MemberController();
	private MainView mainView = new MainView();
	private UserMainView usermainview = new UserMainView();
	private ReservationView reservationView = new ReservationView();
	private ReservationController reserController = new ReservationController();

	public static void main(String[] args) throws Exception{
		Main main = new Main();

		while (true) {
			Map<String, String> menu = main.mainView.main();

			switch (menu.get("menu")) {
			case "1":
				main.memberController.memberregist();
				
			case "2":
				main.memberController.memberlogin();
				while (true) {
					Map<String, String> reservationmenu = main.usermainview.main();
					switch (reservationmenu.get("menu")) {
					case "1":  //영화예매
						Map<String, ReservationVO> request = main.reservationView.memberReservationRegist();
						ReservationVO reservation = (ReservationVO)request.get("reservation");
						main.reserController.reservationRegist(reservation);

						break;
					case "2" : //예매내역조회
						main.reserController.reservationList();
						break;					
					case "3":
						System.out.println("종료되었습니다.");
						return;
					}
						
				}

			case "3":
				System.out.println("프로그램을 종료합니다.");
				return;
			}

		}
	}
}
