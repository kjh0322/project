package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dto.DoctorVO;

import util.DBManager;

public class DoctorDAO {
	private DoctorDAO() {}
	
	private static DoctorDAO instance=new DoctorDAO();
	public static DoctorDAO getInstance() {
		return instance;
	}
	
	// 의료진 리스트 조회 메서드 생성
	public List<DoctorVO> select(){
		List<DoctorVO> list=new ArrayList<DoctorVO>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from doctor order by code asc";	// 최근 등록한 의료진 정보 아래쪽에 나열
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {	
				DoctorVO dVo=new DoctorVO();
				dVo.setCode(rs.getInt("code"));
				dVo.setName(rs.getString("name"));
				dVo.setJob(rs.getString("job"));
				dVo.setProfile1(rs.getString("profile1"));
				dVo.setProfile2(rs.getString("profile2"));
				dVo.setProfile3(rs.getString("profile3"));
				dVo.setProfile4(rs.getString("profile4"));
				dVo.setProfile5(rs.getString("profile5"));
				dVo.setSpec1(rs.getString("spec1"));
				dVo.setSpec2(rs.getString("spec2"));
				dVo.setSpec3(rs.getString("spec3"));
				dVo.setSpec4(rs.getString("spec4"));
				dVo.setSpec5(rs.getString("spec5"));
				dVo.setSpec6(rs.getString("spec6"));
				dVo.setSpec7(rs.getString("spec7"));
				dVo.setSpec8(rs.getString("spec8"));
				dVo.setSpec9(rs.getString("spec9"));
				dVo.setSpec10(rs.getString("spec10"));
				dVo.setImg(rs.getString("img"));
				
				list.add(dVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 의료진 정보를 db에 추가하기 위한 메서드 생성
	public void insertDoctor(DoctorVO dVo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into doctor values(codeNo.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn=DBManager.getConnection();				
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dVo.getName());
			pstmt.setString(2, dVo.getJob());
			pstmt.setString(3, dVo.getProfile1());
			pstmt.setString(4, dVo.getProfile2());
			pstmt.setString(5, dVo.getProfile3());
			pstmt.setString(6, dVo.getProfile4());
			pstmt.setString(7, dVo.getProfile5());
			pstmt.setString(8, dVo.getSpec1());
			pstmt.setString(9, dVo.getSpec2());
			pstmt.setString(10, dVo.getSpec3());
			pstmt.setString(11, dVo.getSpec4());
			pstmt.setString(12, dVo.getSpec5());
			pstmt.setString(13, dVo.getSpec6());
			pstmt.setString(14, dVo.getSpec7());
			pstmt.setString(15, dVo.getSpec8());
			pstmt.setString(16, dVo.getSpec9());
			pstmt.setString(17, dVo.getSpec10());
			pstmt.setString(18, dVo.getImg());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// code로 의료진 정보 가져오는 메서드 생성
	public DoctorVO getDoctor(String code) {
		DoctorVO dVo=null;
				
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from doctor where code=?";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dVo=new DoctorVO();
				
				dVo.setCode(rs.getInt("code"));
				dVo.setName(rs.getString("name"));
				dVo.setJob(rs.getString("job"));
				dVo.setProfile1(rs.getString("profile1"));
				dVo.setProfile2(rs.getString("profile2"));
				dVo.setProfile3(rs.getString("profile3"));
				dVo.setProfile4(rs.getString("profile4"));
				dVo.setProfile5(rs.getString("profile5"));
				dVo.setSpec1(rs.getString("spec1"));
				dVo.setSpec2(rs.getString("spec2"));
				dVo.setSpec3(rs.getString("spec3"));
				dVo.setSpec4(rs.getString("spec4"));
				dVo.setSpec5(rs.getString("spec5"));
				dVo.setSpec6(rs.getString("spec6"));
				dVo.setSpec7(rs.getString("spec7"));
				dVo.setSpec8(rs.getString("spec8"));
				dVo.setSpec9(rs.getString("spec9"));
				dVo.setSpec10(rs.getString("spec10"));
				dVo.setImg(rs.getString("img"));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dVo;
	}
	
	// 의료진 정보 수정을 위한 메서드 생성
	public void updateDoctor(DoctorVO dVo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="update doctor set name=?, job=?, profile1=?, profile2=?, profile3=?, profile4=?, profile5=?, spec1=?, spec2=?, spec3=?, spec4=?, spec5=?, spec6=?, spec7=?, spec8=?, spec9=?, spec10=?, img=? where code=?";
		
		try {
			conn=DBManager.getConnection();			
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, dVo.getName());
			pstmt.setString(2, dVo.getJob());
			pstmt.setString(3, dVo.getProfile1());
			pstmt.setString(4, dVo.getProfile2());
			pstmt.setString(5, dVo.getProfile3());
			pstmt.setString(6, dVo.getProfile4());
			pstmt.setString(7, dVo.getProfile5());
			pstmt.setString(8, dVo.getSpec1());
			pstmt.setString(9, dVo.getSpec2());
			pstmt.setString(10, dVo.getSpec3());
			pstmt.setString(11, dVo.getSpec4());
			pstmt.setString(12, dVo.getSpec5());
			pstmt.setString(13, dVo.getSpec6());
			pstmt.setString(14, dVo.getSpec7());
			pstmt.setString(15, dVo.getSpec8());
			pstmt.setString(16, dVo.getSpec9());
			pstmt.setString(17, dVo.getSpec10());
			pstmt.setString(18, dVo.getImg());
			pstmt.setInt(19, dVo.getCode());
			
			pstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 의료진 정보 삭제를 위한 메서드 생성
	public void deleteDoctor(String code) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from doctor where code=?";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			pstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}





























