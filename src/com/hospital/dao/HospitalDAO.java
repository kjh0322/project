package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dto.HospitalVO;

import util.DBManager;

public class HospitalDAO {
	private HospitalDAO() {}
	
	private static HospitalDAO instance=new HospitalDAO();
	public static HospitalDAO getInstance() {
		return instance;
	}
	
	// 회원 인증 시 사용되는 메서드 생성
	public int userCheck(String id, String pw, String lev) {
		Connection conn=null;			
		PreparedStatement pstmt=null;	
		ResultSet rs=null;				
		
		int result=-1;
		String sql="select * from hospital where id=?";
		
		try {
			conn=DBManager.getConnection();		
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, id);				
			rs=pstmt.executeQuery();			
			
		/*
		 	1. 아이디와 비밀번호가 일치하면서 레벨이 A하고 일치하면 result=2	-> 운영자
			2. 아이디와 비밀번호가 일치하면서 레벨이 B하고 일치하면 result=3	-> 일반회원
			3. 아이디가 있으면서 비밀번호가 일치하지만 레벨이 맞지 않으면 result=1
			4. 아이디가 있으면서 아이디와 비밀번호가 일치하지 않으면 result=0
			5. 아이디, 비밀번호가 없으면 result=-1
		*/
			if(rs.next()) {
				if(rs.getString("pw").equals(pw)) {
					if(rs.getString("lev").equals(lev)) {
						result=2;
						if(lev.equals("B")) {
						result=3;
						}
					}else {
						result=1;
					}
				}else {
					result=0;
				}
			}else {
				result=-1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
		
	// 아이디로 회원 정보 가져오는 메서드 생성
	public HospitalVO getMember(String id) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		HospitalVO hVo=null;
		
		String sql="select * from hospital where id=?";
		
		try {
			conn=DBManager.getConnection();		
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, id);				
			rs=pstmt.executeQuery();			
			
			if(rs.next()) {
				hVo=new HospitalVO();
				hVo.setId(rs.getString("id"));		
				hVo.setPw(rs.getString("pw"));
				hVo.setName(rs.getString("name"));
				hVo.setYear(rs.getInt("year"));
				hVo.setMonth(rs.getInt("month"));
				hVo.setDay(rs.getInt("day"));
				hVo.setGender(rs.getInt("gender"));
				hVo.setPhone(rs.getString("phone"));
				hVo.setEmail1(rs.getString("email1"));
				hVo.setEmail2(rs.getString("email2"));
				hVo.setLev(rs.getString("lev"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return hVo;
	}
	
	// 회원 정보 수정을 위한 메서드 생성
	public int updateMember(HospitalVO hVo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int result=-1;
		String sql="update hospital set pw=?, name=?, year=?, month=?, day=?, gender=?, phone=?, email1=?, email2=?, lev=? where id=?";
		
		try {
			conn=DBManager.getConnection();				
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, hVo.getPw());
			pstmt.setString(2, hVo.getName());
			pstmt.setInt(3, hVo.getYear());
			pstmt.setInt(4, hVo.getMonth());
			pstmt.setInt(5, hVo.getDay());
			pstmt.setInt(6, hVo.getGender());
			pstmt.setString(7, hVo.getPhone());
			pstmt.setString(8, hVo.getEmail1());
			pstmt.setString(9, hVo.getEmail2());
			pstmt.setString(10, hVo.getLev());
			pstmt.setString(11, hVo.getId());
			
			result=pstmt.executeUpdate();		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	// 아이디 중복 체크를 위한 메서드 생성
	public int confirmID(String id) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int result=-1;		// 중복아이디이면 1, 그렇지 아니하면 -1
		String sql="select id from hospital where id=?";
		
		try {
			conn=DBManager.getConnection();		
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=1;
			}else {
				result=-1;
			}
		} catch (Exception e) {
	 		e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 회원 정보를 db에 추가하기 위한 메서드 생성
	public void insertMember(HospitalVO hVo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into hospital values(?,?,?,?,?,?,?,?,?,?,default)";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, hVo.getId());
			pstmt.setString(2, hVo.getPw());
			pstmt.setString(3, hVo.getName());
			pstmt.setInt(4, hVo.getYear());
			pstmt.setInt(5, hVo.getMonth());
			pstmt.setInt(6, hVo.getDay());
			pstmt.setInt(7, hVo.getGender());
			pstmt.setString(8, hVo.getPhone());
			pstmt.setString(9, hVo.getEmail1());
			pstmt.setString(10, hVo.getEmail2());
			
			System.out.println(pstmt.executeUpdate());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 관리자 정보를 db에 추가하기 위한 메서드 생성
	public void insertAdmin(HospitalVO hVo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into hospital values(?,?,?,?,?,?,?,?,?,?,'A')";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, hVo.getId());
			pstmt.setString(2, hVo.getPw());
			pstmt.setString(3, hVo.getName());
			pstmt.setInt(4, hVo.getYear());
			pstmt.setInt(5, hVo.getMonth());
			pstmt.setInt(6, hVo.getDay());
			pstmt.setInt(7, hVo.getGender());
			pstmt.setString(8, hVo.getPhone());
			pstmt.setString(9, hVo.getEmail1());
			pstmt.setString(10, hVo.getEmail2());
			
			System.out.println(pstmt.executeUpdate());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 관리자 리스트 조회 메서드 생성
	public List<HospitalVO> select(){
		List<HospitalVO> list=new ArrayList<HospitalVO>();
		
		Connection conn=null;			
		PreparedStatement pstmt=null;	
		ResultSet rs=null;
		
		HospitalVO hVo=null;
		
		String sql="select id, name, gender, phone from hospital where lev='A' order by id asc";	// 아이디 오름차순
	
		try {
			conn=DBManager.getConnection();		
			pstmt=conn.prepareStatement(sql);	
			rs=pstmt.executeQuery();			
			
			while(rs.next()) {
				hVo=new HospitalVO();
				hVo.setId(rs.getString("id"));	
				hVo.setName(rs.getString("name"));
				hVo.setGender(rs.getInt("gender"));
				hVo.setPhone(rs.getString("phone"));
				
				list.add(hVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;		
	}
	
	// 관리자 정보 삭제를 위한 메서드 생성
	public void delete(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from hospital where id=?";
		
		try {
			conn=DBManager.getConnection();		
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, id);			
			
			pstmt.executeUpdate();			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
