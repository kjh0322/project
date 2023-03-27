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

@WebServlet("/reservationUpdate.do")
public class ReservationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no=request.getParameter("no");				// 선택한 예약정보의 no를 가져와 no에 기억해라
		
		ReservationDAO rDao=ReservationDAO.getInstance();	// ReservationDAO 객체 생성
		ReservationVO rVo=rDao.getReservation(no);			// ReservationDAO의 getReservation 메서드에 기억한 no 값을 매개변수로 해서 예약 정보를 조회해서 rVo에 기억해라
		request.setAttribute("reservation", rVo);			// 이름이 Reservation(파란색)인 속성의 값을 no에 따른 데이터 조회 값을 세팅한 rVo(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("reservationUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리를 위한 코드 추가
		request.setCharacterEncoding("utf-8");
		
		// 진료 상담 예약 수정 폼의 폼에서 입력한 값을 변수에 기억해라
		String no=request.getParameter("no");
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
		
		// 진료 상담 예약 정보 수정 시 수정된 예약 정보를 저장할 객체 생성
		ReservationVO rVo=new ReservationVO();
		
		// 위에서 기억한 예약 정보를 얻어와 생성한 객체 변수 rVo에 세팅
		rVo.setNo(Integer.parseInt(no));
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

		ReservationDAO rDao=ReservationDAO.getInstance();	// ReservationDAO 객체 생성
		rDao.updateReservation(rVo);						// ReservationDAO의 updateReservation 메서드에 rVo 객체 변수에 세팅한 값을 매개변수로 해서 예약 정보를 수정해라		
		
		response.sendRedirect("reservationList.do");
	}
}























