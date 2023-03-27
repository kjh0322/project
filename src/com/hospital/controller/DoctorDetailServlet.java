package com.hospital.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dao.DoctorDAO;
import com.hospital.dto.DoctorVO;

@WebServlet("/doctorDetail.do")
public class DoctorDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");		// 선택한 의료진 정보의 code를 가져와 code에 기억해라
		
		DoctorDAO dDao=DoctorDAO.getInstance();			// DoctorDAO 객체 생성
		DoctorVO dVo=dDao.getDoctor(code);				// DoctorDAO의 getDoctor 메서드에 기억한 code 값을 매개변수로 해서 의료진 정보를 조회해서 dVo에 기억해라
		request.setAttribute("doctor", dVo);			// 이름이 doctor(파란색)인 속성의 값을 code에 따른 데이터 조회 값을 세팅한 dVo(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("doctorDetail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}























