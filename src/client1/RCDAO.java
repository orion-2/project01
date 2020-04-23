package client1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RCDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs; 
	private static RCDAO RCDAOobj;
	
	public RCDAO() {
	}	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
		}
	}
	
	public static RCDAO getInstance() {
		if (RCDAOobj == null) {
			RCDAOobj = new RCDAO();
		}
		return RCDAOobj;
	}
	
	private boolean connect() { //오라클 DB접속 자원
		boolean cFlag=false;
		try {
			conn = DriverManager.getConnection
				(""+"jdbc:oracle:thin:@localhost:1521:orcl","system","1");
			cFlag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cFlag;
	}
	//선주 회원목록보기
	public ArrayList<RCDTO> selAll() {
		ArrayList<RCDTO> rcList = new ArrayList<>();
		String sql = "SELECT * FROM MEMBERC";
		if(connect()) {
			try {
				stmt = conn.createStatement();
				if(stmt != null) {
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						RCDTO rcDTO = new RCDTO();
						rcDTO.setId(rs.getString("ID"));
						rcDTO.setShipNum(rs.getString("SHIPNUM"));
						rcDTO.setShipName(rs.getString("SHIPNAME"));
						rcDTO.setShipAddr(rs.getString("SHIPADDR"));
						rcDTO.setTotalNum(rs.getString("TOTALNUM"));
						rcDTO.setDate(rs.getString("DATA"));
						
						rcList.add(rcDTO);
						
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("DB접속 오류");
		}
		return rcList;
		
	}
	//예약정보등록
	public boolean insertOne(RCDTO rcDTO) {
		boolean cFlag = false;
		if(this.connect()) {
			String sql = "INSERT INTO BOOKINGC VALUES (?,?,?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, rcDTO.getId());
				psmt.setString(2, rcDTO.getShipNum());
				psmt.setString(3, rcDTO.getShipName());
				psmt.setString(4, rcDTO.getShipAddr());
				psmt.setString(5, rcDTO.getTotalNum());
				psmt.setString(6, rcDTO.getDate());
				int r = psmt.executeUpdate();
				
				if(r > 0) {
					cFlag = true;
					System.out.println("성공하였습니다.");
				}
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("DB연결 실패");
			System.exit(0);
		}
		return cFlag;
	}
//	//선주회원등록 삭제
//	public boolean delOne(CDTO m) {
//		 boolean cFlag = false;
//		if(this.connect()) {
//			String sql = "DELETE FROM MEMBERC WHERE ID = ? ";
//			PreparedStatement psmt;
//			try {
//				psmt = conn.prepareStatement(sql);
//				psmt.setString(1, m.getId());
//				psmt.executeUpdate();
//				int r = psmt.executeUpdate();
//				if(r > 0) {
//					cFlag = true;
//				}
//				psmt.close();
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else {
//			System.out.println("DB접속 오류");
//			System.exit(0);
//		}
//		return cFlag;
//	}
}
