import java.sql.*;
public class TestDML {

	public static void main(String[] args) {
		Connection conn=null;
		Statement smt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott","tiger");
			String sql="insert into dept2 values(90,'Game','bj')";
			smt=conn.createStatement();
			smt.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
