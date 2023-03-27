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

@WebServlet("/adminDetail.do")
public class AdminDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");			// 선택한 관리자 정보의 id를 가져와 id에 기억해라
		
		HospitalDAO hDao=HospitalDAO.getInstance();		// HospitalDAO 객체 생성
		HospitalVO hVo=hDao.getMember(id);				// HospitalDAO의 getMember 메서드에 기억한 id 값을 매개변수로 해서 관리자 정보를 조회해서 hVo에 기억해라
		request.setAttribute("admin", hVo);				// 이름이 admin(파란색)인 속성의 값을 id에 따른 데이터 조회 값을 세팅한 hVo(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("adminDetail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}























