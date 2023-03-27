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

@WebServlet("/addAdmin.do")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자 등록 서블릿 => 조건 : 로그인 상태이면서 관리자일 때 관리자 등록 할 수 있다.
		HttpSession session=request.getSession();						// 세션에 저장된 정보를 얻어와 연결
		HospitalVO hVo=(HospitalVO)session.getAttribute("loginUser");	// 로그인 성공시 이 아이디 해당하는 회원 정보를 지정한 loginUser 속성 값을 가져와 hVO에 기억해라
		Integer result=(Integer)session.getAttribute("result");			// 회원 인증 결과 값을 지정한 result 속성 값을 가져와 result에 기억해라
		
		if(hVo != null && result==2) {	// 회원 정보가 존재하면서 회원 인증 결과가 2이면 즉 로그인이 상태이면 관리자일 경우
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("addAdmin.jsp");
			dispatcher.forward(request, response);
						
		}else {
			response.sendRedirect("main.jsp");			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리를 위한 코드 추가
		request.setCharacterEncoding("utf-8");
		
		// 관리자 등록 폼에서 입력한 값을 변수에 기억해라
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
		
		// 관리자 정보를 저장할 객체 생성
		HospitalVO hVo=new HospitalVO();
		
		// 위에서 기억한 관리자 정보를 얻어와 생성한 객체 변수 hVo에 세팅
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
		hDao.insertAdmin(hVo);									// HospitalDAO의 insertAdmin 메서드에 hVo 객체 변수에 세팅한 값을 매개변수로 해서 관리자 정보를 등록해라
		
		request.setAttribute("member", hVo);					// 이름이 member(파란색)인 속성의 값을 관리자 정보를 얻어와 데이터 값을 세팅한 hVo(갈색)로 지정한다.
		request.setAttribute("message", "회원가입이 완료되었습니다.");		// 이름이 message(파란색)인 속성의 값을 회원가입이 완료되었습니다(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("joinsuccess.jsp");
		dispatcher.forward(request, response);
	}

}
