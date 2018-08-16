import java.sql.*;
public class TestJDBC {

	public static void main(String[] args)  {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");												//注册driver
			//new oracle.jdbc.driver.OracleDriver();
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");    //拿到connection
			stmt=conn.createStatement();																	//创建statement												
			rs=stmt.executeQuery("select * from dept");														//执行sql语句放入结果集中
			while(rs.next()) {
				System.out.println(rs.getString("deptno"));													//遍历拿出数据
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
