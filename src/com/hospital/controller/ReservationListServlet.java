package com.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dao.ReservationDAO;
import com.hospital.dto.ReservationVO;

@WebServlet("/reservationList.do")
public class ReservationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationDAO rDao=ReservationDAO.getInstance();				// ReservationDAO 객체 생성
		
		List<ReservationVO> reservationList1=rDao.select1();			// ReservationDAO의 select1 메서드를 실행해서 권용신 의사 예약 정보를 조회한 것을 ReservationList1에 기억해라
		request.setAttribute("reservationList1", reservationList1);		// 이름이 ReservationList1(파란색)인 속성의 값을 권용신 의사 예약 조회 값을 세팅한 ReservationList1(갈색)로 지정한다.

		List<ReservationVO> reservationList2=rDao.select2();			// ReservationDAO의 select2 메서드를 실행해서 최상민 의사 예약 정보를 조회한 것을 ReservationList2에 기억해라
		request.setAttribute("reservationList2", reservationList2);		// 이름이 ReservationList2(파란색)인 속성의 값을 최상민 의사 예약 조회 값을 세팅한 ReservationList2(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("reservationList.jsp");
		dispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
