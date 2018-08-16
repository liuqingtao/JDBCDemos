import java.sql.*;
public class TestProc {

	public static void main(String[] args) {
		Connection conn=null;
		CallableStatement csmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			csmt=conn.prepareCall("{call getMaxAndSum1(?,?)}");
			csmt.registerOutParameter(2,Types.INTEGER);
			csmt.setInt(1,2);
			csmt.setInt(2,3);
			csmt.execute();
			System.out.println(csmt.getInt(2));
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				csmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
