import java.sql.*;
import com.mysql.cj.exceptions.RSAException;
public class TestMysqlConnection {

	public static void main(String[] args) {
		Connection conn=null;
		Statement smt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mydata?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&user=root&password=gogogo");
				smt=conn.createStatement();
				rs=smt.executeQuery("select * from dept");
				while(rs.next()) {
					System.out.println(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(rs!=null) {
						rs.close();
						rs=null;
					}
					if(smt!=null) {
						smt.close();
						smt=null;
					}
					if(conn!=null) {
						conn.close();
						conn=null;
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
