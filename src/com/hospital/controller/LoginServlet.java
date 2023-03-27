package com.hospital.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.HospitalDAO;
import com.hospital.dto.HospitalVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리를 위한 코드 추가
		request.setCharacterEncoding("utf-8");
		
		// 로그인 폼에서 입력한 값을 변수에 기억해라
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String lev=request.getParameter("lev");
		
		String url=null;
		
		HospitalDAO hDao=HospitalDAO.getInstance();		// HospitalDAO 객체 생성
		int result=hDao.userCheck(id,pw,lev);			// HospitalDAO의 userCheck 메서드에 기억한 id, pw, lev 값을 매개변수로 해서 result에 기억해라
		
		// result를 HospitalDAO.userCheck()에서 가져옴
		if(result==2 || result==3) {
			HospitalVO hVo=new HospitalVO();			// 아이디로 가져온 회원 정보를 저장할 객체 생성
			hVo=hDao.getMember(id);						// HospitalDAO의 getMember에 메서드에 기억한 아이디를 매개변수로 해서 아이디로 가져온 회원 정보를 hVo에 기억해라
			
			//세션에 저장된 정보를 얻어와 연결 
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", hVo);		// 이름이 loginUser(파란색)인 속성의 값을 로그인 성공시 이 아이디 해당하는 회원 정보 값을 세팅한 hVo(갈색)로 지정한다.
			session.setAttribute("result", result);		// 이름이 result(파란색)인 속성의 값을 회원 인증 결과 값을 세팅한 result(갈색)로 지정한다.
			url="main.jsp";								// 로그인 성공 시 올바로병원 홈페이지
		}else {	
			url="login.jsp";							// 로그인 실패 시 로그인 페이지		
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
	}
}
