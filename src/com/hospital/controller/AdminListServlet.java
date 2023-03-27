package com.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dao.HospitalDAO;
import com.hospital.dto.HospitalVO;

@WebServlet("/adminList.do")
public class AdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HospitalDAO hDao=HospitalDAO.getInstance();			// HospitalDAO 객체 생성
		List<HospitalVO> adminList=hDao.select();			// HospitalDAO의 select 메서드를 실행해서 관리자 정보를 조회한 것을 adminList에 기억해라
		request.setAttribute("adminList", adminList);		// 이름이 adminList(파란색)인 속성의 값을 관리자 정보 조회 값을 세팅한 adminList(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("adminList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
