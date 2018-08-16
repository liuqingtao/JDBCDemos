import java.sql.*;
public class TestJDBC {

	public static void main(String[] args)  {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");												//ע��driver
			//new oracle.jdbc.driver.OracleDriver();
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");    //�õ�connection
			stmt=conn.createStatement();																	//����statement												
			rs=stmt.executeQuery("select * from dept");														//ִ��sql������������
			while(rs.next()) {
				System.out.println(rs.getString("deptno"));													//�����ó�����
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
					rs=null;
				}
				if(stmt!=null) {
					stmt.close();
					stmt=null;
				}
				if(conn!=null) {
					conn.close();
					conn=null;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}		
	}
}
