package com.hospital.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dao.ReservationDAO;
import com.hospital.dto.ReservationVO;

@WebServlet("/reservationDelete.do")
public class ReservationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no=request.getParameter("no");				// 선택한 예약정보의 no를 가져와 no에 기억해라
		
		ReservationDAO rDao=ReservationDAO.getInstance();	// ReservationDAO 객체 생성
		ReservationVO rVo=rDao.getReservation(no);			// ReservationDAO의 getReservation 메서드에 기억한 no 값을 매개변수로 해서 예약 정보를 조회해서 rVo에 기억해라
		request.setAttribute("reservation", rVo);			// 이름이 Reservation(파란색)인 속성의 값을 no에 따른 데이터 조회 값을 세팅한 rVo(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("reservationDelete.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리를 위한 코드 추가
		request.setCharacterEncoding("utf-8");
		
		String no=request.getParameter("no");				// 선택한 예약정보의 no를 가져와 no에 기억해라
		
		ReservationDAO rDao=ReservationDAO.getInstance();	// ReservationDAO 객체 생성
		rDao.deleteReservation(no);							// ReservationDAO의 deleteReservation 메서드에 기억한 no 값을 매개변수로 해서 예약 정보를 삭제해라
		
		response.sendRedirect("reservationList.do");
	}

}
