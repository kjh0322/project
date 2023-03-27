package com.hospital.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dao.HospitalDAO;

@WebServlet("/idCheck.do")
public class IdCheckSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 자바스크립트로 아이디 중복 체크를 위한 함수를 추가였기에
		// 중복체크버튼 클릭시 idCheck.do 요청
		String id=request.getParameter("id");			// id를 가져와 id에 기억해라 
		
		HospitalDAO hDao=HospitalDAO.getInstance();		// HospitalDAO 객체 생성
		
		int result=hDao.confirmID(id);					// HospitalDAO의 confirmID 메서드에 기억한 id 값을 매개변수로 해서 아이디 중복 체크를 해서 result에 기억해라
		
		request.setAttribute("id", id);					// 이름이 id(파란색)인 속성의 값을 기억한 id(갈색)으로 지정한다.
		request.setAttribute("result", result);			// 이름이 result(파란색)인 속성의 값을 id 값을 매개변수로 해서 아이디 중복 체크한 값을 세팅한 result(갈색)로 지정한다. 중복아이디이면 1, 그렇지 아니하면 -1
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("idcheck.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
