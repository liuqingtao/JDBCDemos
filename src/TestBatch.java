import java.sql.*;
public class TestBatch {

	public static void main(String[] args) {
		Connection conn=null;
		Statement smt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			smt=conn.createStatement();
			smt.addBatch("insert into dept2 values(1,'Game','bj')");
			smt.addBatch("insert into dept2 values(2,'Game','bj')");
			smt.addBatch("insert into dept2 values(3,'Game','bj')");
			smt.executeBatch();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				smt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
