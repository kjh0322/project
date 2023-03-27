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


@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에 저장된 정보를 얻어와 연결
		HttpSession session=request.getSession();						
		HospitalVO hVo=(HospitalVO)session.getAttribute("loginUser");	// 로그인 성공시 이 아이디 해당하는 회원 정보를 지정한 loginUser 속성 값을 가져와 hVO에 기억해라
		   
		   if(hVo != null) {	// 회원 정보가 존재한다면 즉 로그인 상태이면
			   String url="mypage.jsp";
			   
			   RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			   dispatcher.forward(request, response);
		   }else {
			   response.sendRedirect("login.do");
		   }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리를 위한 코드 추가
		request.setCharacterEncoding("utf-8");
		
		// 마이페이지 폼에서 입력한 값을 변수에 기억해라
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
		
		// 회원 정보를 저장할 객체 생성
		HospitalVO member=new HospitalVO();
		
		// 위에서 기억한 회원 정보를 얻어와 생성한 객체 변수 member에 세팅
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setYear(Integer.parseInt(year));
		member.setMonth(Integer.parseInt(month));
		member.setDay(Integer.parseInt(day));
		member.setGender(Integer.parseInt(gender));
		member.setPhone(phone);
		member.setEmail1(email1);
		member.setEmail2(email2);
		member.setLev(lev);
		
		HospitalDAO hDao=HospitalDAO.getInstance();			// HospitalDAO 객체 생성
		hDao.updateMember(member);							// HospitalDAO의 updateMember 메서드에 member 객체 변수에 세팅한 값을 매개변수로 해서 회원 정보를 수정해라
		
		//회원 정보 수정 폼 만들기 위한 VO 객체에서 아이디에 해당하는 자료 가져오기
		HospitalVO hVo=hDao.getMember(member.getId());		// HospitalDAO의 getMember 메서드에 로그인한 회원 정보 아이디를 매개변수로 해서 수정한 회원 정보를 hVo에 기억해라
		request.setAttribute("member", hVo);				// 이름이 member(파란색)인 속성의 값을 수정한 회원 정보를 얻어와 데이터 값을 세팅한 hVo(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("clear.jsp");
		dispatcher.forward(request, response);		
	}

}
