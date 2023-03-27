package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dto.ReservationVO;

import util.DBManager;

public class ReservationDAO {
	private ReservationDAO() {}
	
	private static ReservationDAO instance=new ReservationDAO();
	public static ReservationDAO getInstance() {
		return instance;
	}
		
	// 권용신 의료진 예약 리스트 조회 메서드 생성
	public List<ReservationVO> select1(){
		List<ReservationVO> list=new ArrayList<ReservationVO>();
		
		Connection conn=null;			
		PreparedStatement pstmt=null;	
		ResultSet rs=null;
		
		ReservationVO rVo=null;
		
		String sql="select no, name, gender, rsy, rsm, rsd, rsh, rsmin, phone from reservation where doctor='권용신' order by no asc";		// 최근 등록한 예약 정보 아래쪽에 나열	
	
		try {
			conn=DBManager.getConnection();		
			pstmt=conn.prepareStatement(sql);	
			rs=pstmt.executeQuery();			
			
			while(rs.next()) {
				rVo=new ReservationVO();
				rVo.setNo(rs.getInt("no"));
				rVo.setName(rs.getString("name"));
				rVo.setGender(rs.getInt("gender"));
				rVo.setRsy(rs.getInt("rsy"));
				rVo.setRsm(rs.getInt("rsm"));
				rVo.setRsd(rs.getInt("rsd"));
				rVo.setRsh(rs.getInt("rsh"));
				rVo.setRsmin(rs.getInt("rsmin"));
				rVo.setPhone(rs.getString("phone"));
				
				list.add(rVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;		
	}
	
	// 최상민 의료진 예약 리스트 조회 메서드 생성
	public List<ReservationVO> select2(){
		List<ReservationVO> list=new ArrayList<ReservationVO>();
		
		Connection conn=null;			
		PreparedStatement pstmt=null;	
		ResultSet rs=null;
		
		ReservationVO rVo=null;
		
		String sql="select no, name, gender, rsy, rsm, rsd, rsh, rsmin, phone from reservation where doctor='최상민' order by no asc";		// 최근 등록한 예약 정보 아래쪽에 나열	
	
		try {
			conn=DBManager.getConnection();		
			pstmt=conn.prepareStatement(sql);	
			rs=pstmt.executeQuery();			
			
			while(rs.next()) {
				rVo=new ReservationVO();
				rVo.setNo(rs.getInt("no"));	
				rVo.setName(rs.getString("name"));
				rVo.setGender(rs.getInt("gender"));
				rVo.setRsy(rs.getInt("rsy"));
				rVo.setRsm(rs.getInt("rsm"));
				rVo.setRsd(rs.getInt("rsd"));
				rVo.setRsh(rs.getInt("rsh"));
				rVo.setRsmin(rs.getInt("rsmin"));
				rVo.setPhone(rs.getString("phone"));
				
				list.add(rVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;		
	}
	
	// 예약 정보를 db에 추가하기 위한 메서드 생성
	public void insertReservation(ReservationVO rVo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into reservation values(seq_no.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn=DBManager.getConnection();				
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, rVo.getId());
			pstmt.setString(2, rVo.getName());
			pstmt.setInt(3, rVo.getGender());
			pstmt.setInt(4, rVo.getYear());
			pstmt.setInt(5, rVo.getMonth());
			pstmt.setInt(6, rVo.getDay());
			pstmt.setString(7, rVo.getPhone());
			pstmt.setString(8, rVo.getDoctor());
			pstmt.setInt(9, rVo.getRsy());
			pstmt.setInt(10, rVo.getRsm());
			pstmt.setInt(11, rVo.getRsd());
			pstmt.setInt(12, rVo.getRsh());
			pstmt.setInt(13, rVo.getRsmin());
			pstmt.setString(14, rVo.getContent());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// no로 예약 정보 가져오는 메서드 생성
	public ReservationVO getReservation(String no) {
		ReservationVO rVo=null;
				
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from reservation where no=?";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				rVo=new ReservationVO();
				rVo.setNo(rs.getInt("no"));
				rVo.setId(rs.getString("id"));
				rVo.setName(rs.getString("name"));
				rVo.setGender(rs.getInt("gender"));
				rVo.setYear(rs.getInt("year"));
				rVo.setMonth(rs.getInt("month"));
				rVo.setDay(rs.getInt("day"));
				rVo.setPhone(rs.getString("phone"));
				rVo.setDoctor(rs.getString("doctor"));
				rVo.setRsy(rs.getInt("rsy"));
				rVo.setRsm(rs.getInt("rsm"));
				rVo.setRsd(rs.getInt("rsd"));
				rVo.setRsh(rs.getInt("rsh"));
				rVo.setRsmin(rs.getInt("rsmin"));
				rVo.setContent(rs.getString("content"));		
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return rVo;
	}
	
	// 예약 정보 수정을 위한 메서드 생성하기
	public void updateReservation(ReservationVO rVo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="update reservation set id=?, name=?, gender=?, year=?, month=?, day=?, phone=?, doctor=?, rsy=?, rsm=?, rsd=?, rsh=?, rsmin=?, content=? where no=?";
		
		try {
			conn=DBManager.getConnection();			
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, rVo.getId());
			pstmt.setString(2, rVo.getName());
			pstmt.setInt(3, rVo.getGender());
			pstmt.setInt(4, rVo.getYear());
			pstmt.setInt(5, rVo.getMonth());
			pstmt.setInt(6, rVo.getDay());
			pstmt.setString(7, rVo.getPhone());
			pstmt.setString(8, rVo.getDoctor());
			pstmt.setInt(9, rVo.getRsy());
			pstmt.setInt(10, rVo.getRsm());
			pstmt.setInt(11, rVo.getRsd());
			pstmt.setInt(12, rVo.getRsh());
			pstmt.setInt(13, rVo.getRsmin());
			pstmt.setString(14, rVo.getContent());
			pstmt.setInt(15, rVo.getNo());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 예약 정보 삭제를 위한 메서드 생성
	public void deleteReservation(String no) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from reservation where no=?";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			pstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}





























