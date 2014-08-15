package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBoardListTest {
	public static void main(String[] args) {
		// JDBC ���� ���� ����
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// Connection ����	
			conn = JDBCUtil.getConnection();
			String sql = "select * from board order by seq desc";
			// PreparedStatement ����
			stmt = conn.prepareStatement(sql);
			// SQL ��ɾ� ���� �� ��� ó���ϱ�
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
			// Connection ���� ����
			JDBCUtil.close(rs, stmt, conn);
		}

	}
}







