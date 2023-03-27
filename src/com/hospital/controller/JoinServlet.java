package com.hospital.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dao.HospitalDAO;
import com.hospital.dto.HospitalVO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("join.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리를 위한 코드 추가
		request.setCharacterEncoding("utf-8");
		
		// 회원가입 폼에서 입력한 값을 변수에 기억해라
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		String lev=request.getParameter("lev");
		
		// 회원가입 시 회원 정보를 저장할 객체 생성
		HospitalVO hVo=new HospitalVO();
		
		// 위에서 기억한 회원 정보를 얻어와 생성한 객체 변수 hVo에 세팅
		hVo.setId(id);
		hVo.setPw(pw);
		hVo.setName(name);
		hVo.setYear(Integer.parseInt(year));
		hVo.setMonth(Integer.parseInt(month));
		hVo.setDay(Integer.parseInt(day));
		hVo.setGender(Integer.parseInt(gender));
		hVo.setPhone(phone);
		hVo.setEmail1(email1);
		hVo.setEmail2(email2);
		hVo.setLev(lev);
		
		HospitalDAO hDao=HospitalDAO.getInstance();				// HospitalDAO 객체 생성
		hDao.insertMember(hVo);									// HospitalDAO의 insertMember 메서드에 hVo 객체 변수에 세팅한 값을 매개변수로 해서 회원가입 실행라
		
		request.setAttribute("member", hVo);					// 이름이 member(파란색)인 속성의 값을 회원가입 정보를 얻어와 데이터 값을 세팅한 hVo(갈색)로 지정한다.
		request.setAttribute("message", "회원가입이 완료되었습니다.");		// 이름이 message(파란색)인 속성의 값을 회원가입이 완료되었습니다(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("joinsuccess.jsp");
		dispatcher.forward(request, response);
	}

}
