package com.hospital.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dao.DoctorDAO;
import com.hospital.dto.DoctorVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/doctorUpdate.do")
public class DoctorUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");	// 선택한 의료진의 code를 가져와 code에 기억해라 
		
		DoctorDAO dDao=DoctorDAO.getInstance();		// DoctorDAO 객체 생성
		DoctorVO dVo=dDao.getDoctor(code);			// DoctorDAO의 getDoctor 메서드에 기억한 code 값을 매개변수로 해서 의료진 정보를 조회해서 dVo에 기억해라
		request.setAttribute("doctor", dVo);		// 이름이 doctor(파란색)인 속성의 값을 코드에 따른 데이터 조회 값을 세팅한 dVo(갈색)로 지정한다.
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("doctorUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리를 위한 코드 추가
		request.setCharacterEncoding("utf-8");
		
		// pageContext내장객체 => 파일 저장 폴더 지정
		ServletContext context=getServletContext();		// 페이지에 대한 실행 환경 정보를 얻어옴.
		String path=context.getRealPath("img");			// 업로드하여 저장할 전체 path 경로
		
		int sizeLimit=10*1024*1024;						// 최대 업로드 파일 크기 10MB로 제한
		String encType="utf-8";							// 파일의 인코딩 방식을 uft-8로 한다.
		
		MultipartRequest multi=new MultipartRequest(
			request,									// request 객체
			path,										// 서버상의 실제 저장 디렉토리
			sizeLimit,									// 최대 업로드 파일 크기
			encType,									// 인코딩방법
			new DefaultFileRenamePolicy()				// 업로드시킨 파일이 동일한 이름이 존재하면 새로운 이름 부여됨
		);
		
		// 의료진 정보 수정 폼에서 입력한 값을 변수에 기억해라
		String code=multi.getParameter("code");
		String name=multi.getParameter("name");
		String job=multi.getParameter("job");
		String profile1=multi.getParameter("profile1");
		String profile2=multi.getParameter("profile2");
		String profile3=multi.getParameter("profile3");
		String profile4=multi.getParameter("profile4");
		String profile5=multi.getParameter("profile5");
		String spec1=multi.getParameter("spec1");
		String spec2=multi.getParameter("spec2");
		String spec3=multi.getParameter("spec3");
		String spec4=multi.getParameter("spec4");
		String spec5=multi.getParameter("spec5");
		String spec6=multi.getParameter("spec6");
		String spec7=multi.getParameter("spec7");
		String spec8=multi.getParameter("spec8");
		String spec9=multi.getParameter("spec9");
		String spec10=multi.getParameter("spec10");
		String img=multi.getFilesystemName("img");
		
		// img 선택 안할 시 기존의 img를 사용해라는 의미
		if(img==null) {
			img=multi.getParameter("noImg");
		}
		
		// 의료진 정보 수정 시 수정된 의료진 정보를 저장할 객체 생성
		DoctorVO dVo=new DoctorVO();
		
		// 위에서 기억한 의료진 정보를 얻어와 생성한 객체 변수 rVo에 세팅
		dVo.setCode(Integer.parseInt(code));
		dVo.setName(name);
		dVo.setJob(job);
		dVo.setProfile1(profile1);
		dVo.setProfile2(profile2);
		dVo.setProfile3(profile3);
		dVo.setProfile4(profile4);
		dVo.setProfile5(profile5);
		dVo.setSpec1(spec1);
		dVo.setSpec2(spec2);
		dVo.setSpec3(spec3);
		dVo.setSpec4(spec4);
		dVo.setSpec5(spec5);
		dVo.setSpec6(spec6);
		dVo.setSpec7(spec7);
		dVo.setSpec8(spec8);
		dVo.setSpec9(spec9);
		dVo.setSpec10(spec10);
		dVo.setImg(img);

		
		DoctorDAO dDao=DoctorDAO.getInstance();		// DoctorDAO 객체 생성
		dDao.updateDoctor(dVo);						// DoctorDAO의 updateDoctor 메서드에 dVo에 세팅한 값을 매개변수로 해서 의료진 정보를 수정해라		
		
		response.sendRedirect("doctorList.do");
	}
}























