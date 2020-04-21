package client1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs; 
	private static CDAO CDAOobj;
	private CDTO member = new CDTO();
	
	public CDAO() {
	}	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
		}
	}
	
	public static CDAO getInstance() {
		if (CDAOobj == null) {
			CDAOobj = new CDAO();
		}
		return CDAOobj;
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
	public ArrayList<String[]> selectAll() {
		ArrayList<String[]> cList = new ArrayList<>();
		String sql = "SELECT * FROM MEMBERC";
		if(connect()) {
			try {
				stmt = conn.createStatement();
				if(stmt != null) {
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						member.setId(rs.getString("ID"));
						member.setPw(rs.getString("PASSWORD"));
						member.setName(rs.getString("NAME"));
						member.setPNum(rs.getString("PNUM"));
						member.setShipNum(rs.getString("SHIPNUM"));
						member.setShipName(rs.getString("SHIPNAME"));
						member.setShipAddr(rs.getString("SHIPADDR"));
						
						cList.add(member.getArray());
						
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("DB접속 오류");
		}
		return cList;
		
	}
	//선주회원등록
	public boolean insertOne(CDTO ex2) {
		boolean cFlag = false;
		if(this.connect()) {
			String sql = "INSERT INTO MEMBERC VALUES (?,?,?,?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, ex2.getId());
				psmt.setString(2, ex2.getPw());
				psmt.setString(3, ex2.getName());
				psmt.setString(4, ex2.getPNum());
				psmt.setString(5, ex2.getShipNum());
				psmt.setString(6, ex2.getShipName());
				psmt.setString(7, ex2.getShipAddr());
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
	//선주회원등록 삭제
	public boolean delOne(CDTO m) {
		 boolean cFlag = false;
		if(this.connect()) {
			String sql = "DELETE FROM MEMBERC WHERE ID = ? ";
			PreparedStatement psmt;
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, m.getId());
				psmt.executeUpdate();
				int r = psmt.executeUpdate();
				if(r > 0) {
					cFlag = true;
				}
				psmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("DB접속 오류");
			System.exit(0);
		}
		return cFlag;
	}
	

	
	
}

