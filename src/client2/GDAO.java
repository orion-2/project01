package client2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs; 
	private static GDAO CDAOobj;
	
	public GDAO() {
	}	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
		}
	}
	
	public static GDAO getInstance() {
		if (CDAOobj == null) {
			CDAOobj = new GDAO();
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
	public ArrayList<GDTO> selAll() {
		ArrayList<GDTO> gList = new ArrayList<>();
		String sql = "SELECT * FROM MEMBERG";
		if(connect()) {
			try {
				stmt = conn.createStatement();
				if(stmt != null) {
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						GDTO ex2 = new GDTO();
						ex2.setId(rs.getString("ID"));
						ex2.setPw(rs.getString("PW"));
						ex2.setName(rs.getString("NAME"));
						ex2.setPNum(rs.getString("PNUM"));
						gList.add(ex2);
						
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("DB접속 오류");
		}
		return gList;
		
	}
	//선주회원등록
	public boolean insertOne(GDTO ex3) {
		boolean cFlag = false;
		if(this.connect()) {
			String sql = "INSERT INTO MEMBERG VALUES (?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, ex3.getId());
				psmt.setString(2, ex3.getPw());
				psmt.setString(3, ex3.getName());
				psmt.setString(4, ex3.getPNum());
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
	public boolean delOne(GDTO m) {
		 boolean cFlag = false;
		if(this.connect()) {
			String sql = "DELETE FROM MEMBERG WHERE ID = ? ";
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

