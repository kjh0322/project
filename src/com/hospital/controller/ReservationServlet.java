package com.hospital.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.ReservationDAO;
import com.hospital.dto.HospitalVO;
import com.hospital.dto.ReservationVO;


@WebServlet("/reservation.do")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//예약 등록 서블릿 => 조건 : 로그인 상태이면서 일반회원일 때 예약 등록 할 수 있다.
		HttpSession session=request.getSession();						//세션에 저장된 정보를 얻어와 연결
		HospitalVO hVo=(HospitalVO)session.getAttribute("loginUser");	// 로그인 성공시 이 아이디 해당하는 회원 정보를 지정한 loginUser 속성 값을 가져와 hVO에 기억해라
		Integer result=(Integer)session.getAttribute("result");			// 회원 인증 결과 값을 지정한 result 속성 값을 가져와 result에 기억해라
		
		if(hVo != null && result==3) {	// 회원 정보가 존재하면서 회원 인증 결과가 3이면 즉 로그인이 상태이면 일반회원일 경우
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("reservation.jsp");
			dispatcher.forward(request, response);
						
		}else {
			response.sendRedirect("main.jsp");			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리를 위한 코드 추가
		request.setCharacterEncoding("utf-8");
		
		// 진료 상담 요청 폼에서 입력한 값을 변수에 기억해라
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
		
		// 진료 상담 요청 정보를 저장할 객체 생성
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
		
		request.setAttribute("reservation", rVo);				// 이름이 reservation(파란색)인 속성의 값을 등록한 진료 상담 예약 정보를 얻어와 데이터 값을 세팅한 rVo(갈색)로 지정한다.
		request.setAttribute("message", "감사합니다.");				// 이름이 message(파란색)인 속성의 값을 감사합니다(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("rssuccess.jsp");
		dispatcher.forward(request, response);
	}


}
