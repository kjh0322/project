package com.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dao.DoctorDAO;
import com.hospital.dto.DoctorVO;

@WebServlet("/doctorList.do")
public class DoctorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorDAO dDao=DoctorDAO.getInstance();				// DoctorDAO 객체 생성
		List<DoctorVO> doctorList=dDao.select();			// DoctorDAO의 select 메서드를 실행해서 의료진 정보를 조회한 것을 DoctorList에 기억해라
		request.setAttribute("doctorList", doctorList);		// 이름이 DoctorList(파란색)인 속성의 값을 의료진 정보 조회 값을 세팅한 DoctorList(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("doctorList.jsp");
		dispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
