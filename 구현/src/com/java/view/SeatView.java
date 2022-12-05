package com.java.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.dto.SeatInfoVO;
import com.java.dto.TheaterVO;


public class SeatView {


	public void theaterSeatAll(TheaterVO theater) {	

		List<String> seatNum = new ArrayList<String>();

		int seatRow = theater.getTheater_seat_row().charAt(0)-'A'+1;
		int seatCol = Integer.parseInt(theater.getTheater_seat_col());

		for (int row = 0; row < seatRow; row++) {
			char r = (char) ('A' + row);
			for (int col = 1; col < seatCol + 1; col++) {
				seatNum.add("" + r + col);
			}

		}

		for (int row = 0; row < seatCol * 4; row++)
			System.out.print("*");
		System.out.println();
		for (int row = 0; row < seatCol * 3; row++)
			System.out.print(" ");
		System.out.println("ÁÂ¼® ¹èÄ¡µµ\n");
		for (int row = 0; row < seatCol * 4; row++)
			System.out.print("*");
		System.out.print("\n");
		for (int index = 0; index < seatNum.size(); index++) {
			
			//if(
			System.out.print(seatNum.get(index) + " ");
			
			
			if ((index + 1) % seatCol == 0)
				System.out.print("\n");
		}
	}

}
