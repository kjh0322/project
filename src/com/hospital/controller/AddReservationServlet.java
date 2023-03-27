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

@WebServlet("/addReservation.do")
public class AddReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("addReservation.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리를 위한 코드 추가
		request.setCharacterEncoding("utf-8");
		
		// 진료 상담 예약 등록 폼에서 입력한 값을 변수에 기억해라
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String phone=request.getParameter("phone");
		String doctor=request.getParameter("doctor");
		String rsy=request.getParameter("rsy");
		String rsm=request.getParameter("rsm");
		String rsd=request.getParameter("rsd");
		String rsh=request.getParameter("rsh");
		String rsmin=request.getParameter("rsmin");
		String content=request.getParameter("content");
		
		// 진료 상담 예약 정보를 저장할 객체 생성 
		ReservationVO rVo=new ReservationVO();
		
		// 위에서 기억한 예약 정보를 얻어와 생성한 객체 변수 rVo에 세팅
		rVo.setId(id);
		rVo.setName(name);
		rVo.setGender(Integer.parseInt(gender));
		rVo.setYear(Integer.parseInt(year));
		rVo.setMonth(Integer.parseInt(month));
		rVo.setDay(Integer.parseInt(day));
		rVo.setPhone(phone);
		rVo.setDoctor(doctor);
		rVo.setRsy(Integer.parseInt(rsy));
		rVo.setRsm(Integer.parseInt(rsm));
		rVo.setRsd(Integer.parseInt(rsd));
		rVo.setRsh(Integer.parseInt(rsh));
		rVo.setRsmin(Integer.parseInt(rsmin));
		rVo.setContent(content);
		
		ReservationDAO rDao=ReservationDAO.getInstance();		// ReservationDAO 객체 생성
		rDao.insertReservation(rVo);							// ReservationDAO의 insertReservation 메서드에 rVo 객체 변수에 세팅한 값을 매개변수로 해서 예약 정보를 등록해라
		
		response.sendRedirect("reservationList.do");
	}

}
