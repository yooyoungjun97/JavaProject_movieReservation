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
		System.out.println("*	                                                      �����ϱ�                                                              *");
		System.out.println("*                                                                       *");
		System.out.println("*                                                                       *");
		System.out.println("*************************************************************************");
		MemberVO loginUser = LoginUserSession.getLoginUser();
		reservation.setMember_phone_num(loginUser.getMember_phone_num());

		do {
			System.out.println("�������� �Է�(�� yyyy-mm-dd): ");
			try {
				reservation.setReservation_date(new SimpleDateFormat("yyyy-MM-dd").parse(scan.nextLine()));
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("�Է������� �ùٸ��� �ʽ��ϴ�.");
			}
		} while (reservation.getReservation_date() == null);

		List<CinemaVO> cinemaList = cinemaService.getCinemaList("");
		int menuNum = 1;
		for (CinemaVO cinema : cinemaList) {
			System.out.println(menuNum + "." + cinema.getCinema_name());
		}
		System.out.println();

		System.out.print("��ȭ���� �����ϼ���: ");
		int indexNum = Integer.parseInt(scan.nextLine()) - 1;
		CinemaVO cinema = cinemaList.get(indexNum);
		reservation.setCinema_identical_number(cinema.getCinema_identical_number());
		List<TheaterVO> theaterList = theaterService.getTheaterList(cinema.getCinema_identical_number());

		menuNum = 1;
		for (TheaterVO theater : theaterList) {
			System.out.println(menuNum + "." + theater.getTheater_name());
		}
		System.out.println();

		System.out.print("�󿵰��� �����ϼ��� :");
		indexNum = Integer.parseInt(scan.nextLine()) - 1;
		TheaterVO theater = theaterList.get(indexNum);
		reservation.setTheater_identical_number(theater.getTheater_identical_number());

		seatview.theaterSeatAll(theater);
		List<ReservationSeatVO> theaterSeatList = reservationService
				.getReservationSeat(theater.getTheater_identical_number());
		if (theaterSeatList != null) {
			System.out.print("����� �¼� : ");
			for (ReservationSeatVO seat : theaterSeatList) {
				System.out.print(seat.getSeat_choice_num());
			}
			System.out.println();
		}
		System.out.println("�¼��� �����ϼ���.(�����¼� ����! ','�� �����Ͻÿ�) : ");
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
		System.out.print("��ȭ�� �����ϼ���: ");

		indexNum = Integer.parseInt(scan.nextLine()) - 1;
		MovieVO movie = movieList.get(indexNum);
		reservation.setMovie_identical_number(movie.getMovie_identical_number());

		System.out.println("***********************************************************************************");
		System.out.println("*                                                                                 *");
		System.out.println("*                             ����ȭ�� �Դϴ�.                                        *");
		System.out.println("*                         �����Ͻ� ������ �Է����ּ���.                                   *");
		System.out.println("*                                                                                 *");
		System.out.println("***********************************************************************************");

		System.out.println("��������(�ſ�ī��/�ڵ�������): ");
		choice = scan.nextLine();
		System.out.println(choice + "������ �Ϸ��Ͽ����ϴ�.");

		reservation.setReservation_payment(choice);

		request.put("reservation", reservation);

		return request;

	}

	
	
	public void reservationList(List<ReservationVO> reservationList)throws SQLException {
		System.out.println("***************************************************************************");
		System.out.println("***********************        ���ų��� ��ȸ              ***************************");
		System.out.println("* ��ȭ��\t�󿵰�\t\t��ȭ\t�¼�\t��¥");
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
