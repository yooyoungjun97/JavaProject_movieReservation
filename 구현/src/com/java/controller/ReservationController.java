package com.java.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.java.dto.PaymentVO;
import com.java.dto.ReservationVO;
import com.java.service.ReservationService;
import com.java.service.ReservationServiceImpl;
import com.java.view.ReservationView;

public class ReservationController {

	private ReservationService reservationservice = new ReservationServiceImpl();
	private ReservationView view = new ReservationView();
	// 예매 수정
	
	//예매내역리스트
	public void reservationList()throws SQLException {
		List<ReservationVO> reservationList = reservationservice.getReservationList(null, null);
		view.reservationList(reservationList);
		
	}
	
	// ** 영화 수정부분 선생님 여쭤보기 **//
	public void ReservationMoidfy() {
			
			Map<String, ReservationVO> controllerRequest = view.ReservationModify();

			try {
				reservationservice.modify(controllerRequest.());

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	// 예매등록

	public void reservationRegist(ReservationVO reservation) {

		try {

			reservationservice.regist(reservation);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 결제 수정

	public void PaymentMoidfy() {
			
			Map<String, PaymentVO> controllerRequest = view.PaymentModify();

			try {
				paymentservice.modify(controllerRequest.());

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

}
