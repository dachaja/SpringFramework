package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBoardListTest {
	public static void main(String[] args) {
		// JDBC 관련 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// Connection 연결	
			conn = JDBCUtil.getConnection();
			String sql = "select * from board order by seq desc";
			// PreparedStatement 생성
			stmt = conn.prepareStatement(sql);
			// SQL 명령어 실행 및 결과 처리하기
			rs = stmt.executeQuery();
			while(rs.next()){
				int seq = rs.getInt("seq");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				Date regDate = rs.getDate("regdate");
				int cnt = rs.getInt("cnt");
				System.out.println(seq + " : " + title + " : " + regDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			// Connection 연결 해제
			JDBCUtil.close(rs, stmt, conn);
		}

	}
}







