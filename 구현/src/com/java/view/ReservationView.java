package com.java.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.CinemaVO;
import com.java.dto.MemberVO;
import com.java.dto.MovieVO;
import com.java.dto.ReservationSeatVO;
import com.java.dto.ReservationVO;
import com.java.dto.TheaterVO;
import com.java.service.CinemaService;
import com.java.service.CinemaServiceImpl;
import com.java.service.MovieService;
import com.java.service.MovieServiceImpl;
import com.java.service.ReservationService;
import com.java.service.ReservationServiceImpl;
import com.java.service.TheaterService;
import com.java.service.TheaterServiceImpl;
import com.java.session.LoginUserSession;

public class ReservationView {

	private SeatView seatview = new SeatView();
	private ReservationService reservationService = new ReservationServiceImpl();
	private CinemaService cinemaService = new CinemaServiceImpl();
	private TheaterService theaterService = new TheaterServiceImpl();
	private MovieService movieService = new MovieServiceImpl();

	String choice = "";

	public Map<String, ReservationVO> memberReservationRegist() throws Exception {

		Map<String, ReservationVO> request = new HashMap<String, ReservationVO>();

		Scanner scan = new Scanner(System.in);

		ReservationVO reservation = new ReservationVO();
		List<ReservationSeatVO> reservationSeatList = new ArrayList<ReservationSeatVO>();

		System.out.println("*************************************************************************");
		System.out.println("*                                                                       *");
		System.out.println("*                                                                       *");
		System.out.println("*                                                                       *");
		System.out.println("*	                                                      예매하기                                                              *");
		System.out.println("*                                                                       *");
		System.out.println("*                                                                       *");
		System.out.println("*************************************************************************");
		MemberVO loginUser = LoginUserSession.getLoginUser();
		reservation.setMember_phone_num(loginUser.getMember_phone_num());

		do {
			System.out.println("예매일자 입력(예 yyyy-mm-dd): ");
			try {
				reservation.setReservation_date(new SimpleDateFormat("yyyy-MM-dd").parse(scan.nextLine()));
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("입력형식이 올바르지 않습니다.");
			}
		} while (reservation.getReservation_date() == null);

		List<CinemaVO> cinemaList = cinemaService.getCinemaList("");
		int menuNum = 1;
		for (CinemaVO cinema : cinemaList) {
			System.out.println(menuNum + "." + cinema.getCinema_name());
		}
		System.out.println();

		System.out.print("영화관을 선택하세요: ");
		int indexNum = Integer.parseInt(scan.nextLine()) - 1;
		CinemaVO cinema = cinemaList.get(indexNum);
		reservation.setCinema_identical_number(cinema.getCinema_identical_number());
		List<TheaterVO> theaterList = theaterService.getTheaterList(cinema.getCinema_identical_number());

		menuNum = 1;
		for (TheaterVO theater : theaterList) {
			System.out.println(menuNum + "." + theater.getTheater_name());
		}
		System.out.println();

		System.out.print("상영관을 선택하세요 :");
		indexNum = Integer.parseInt(scan.nextLine()) - 1;
		TheaterVO theater = theaterList.get(indexNum);
		reservation.setTheater_identical_number(theater.getTheater_identical_number());

		seatview.theaterSeatAll(theater);
		List<ReservationSeatVO> theaterSeatList = reservationService
				.getReservationSeat(theater.getTheater_identical_number());
		if (theaterSeatList != null) {
			System.out.print("예약된 좌석 : ");
			for (ReservationSeatVO seat : theaterSeatList) {
				System.out.print(seat.getSeat_choice_num());
			}
			System.out.println();
		}
		System.out.println("좌석을 선택하세요.(여러좌석 가능! ','로 구분하시오) : ");
		String[] seats = scan.nextLine().split(",");

		if (seats != null && seats.length > 0) {
			for (String seatNum : seats) {
				ReservationSeatVO seat = new ReservationSeatVO();
				seat.setSeat_choice_num(seatNum);
				seat.setTheater_indentical_number(theater.getTheater_identical_number());

				reservationSeatList.add(seat);
			}
		}
		;

		reservation.setSeatList(reservationSeatList);

		List<MovieVO> movieList = movieService.getMovieListByTheater(theater.getTheater_identical_number());
		menuNum = 1;
		for (MovieVO movie : movieList) {
			System.out.println(menuNum + "." + movie.getMovie_title());
		}
		System.out.println();
		System.out.print("영화를 선택하세요: ");

		indexNum = Integer.parseInt(scan.nextLine()) - 1;
		MovieVO movie = movieList.get(indexNum);
		reservation.setMovie_identical_number(movie.getMovie_identical_number());

		System.out.println("***********************************************************************************");
		System.out.println("*                                                                                 *");
		System.out.println("*                             결제화면 입니다.                                        *");
		System.out.println("*                         결제하실 수단을 입력해주세요.                                   *");
		System.out.println("*                                                                                 *");
		System.out.println("***********************************************************************************");

		System.out.println("결제수단(신용카드/핸드폰결제): ");
		choice = scan.nextLine();
		System.out.println(choice + "결제를 완료하였습니다.");

		reservation.setReservation_payment(choice);

		request.put("reservation", reservation);

		return request;

	}

	
	
	public void reservationList(List<ReservationVO> reservationList)throws SQLException {
		System.out.println("***************************************************************************");
		System.out.println("***********************        예매내역 조회              ***************************");
		System.out.println("* 영화관\t상영관\t\t영화\t좌석\t날짜");
		if (reservationList != null)
			for (ReservationVO reservation : reservationList) {
				System.out.println(cinemaService.getCinema(reservation.getCinema_identical_number()).getCinema_name()+"\t"
						+theaterService.getTheater(reservation.getTheater_identical_number()).getTheater_name()+"\t\t"
						+movieService.getMovieByMovie_identical_number(reservation.getMovie_identical_number()).getMovie_title()+"\t"
						+reservation.getSeatList()+"\t"
						+new SimpleDateFormat("yyyy-MM-dd").format(reservation.getReservation_date()));
			}
		System.out.println("*************************************************************************");
	}

}
