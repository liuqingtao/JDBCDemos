import java.sql.*;
import com.mysql.cj.exceptions.RSAException;
public class ArticleTree {

	public static void main(String[] args) {
		new ArticleTree().show();

	}
	public void show() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			try {
				//注册驱动
				Class.forName("com.mysql.cj.jdbc.Driver");
				//System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
				//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//创建连接
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bbs?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&user=root&password=gogogo");
			//创建语句对象
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from article where pid=0");
			while(rs.next()) {
				System.out.println(rs.getString("cont"));
				tree(conn, rs.getInt("id"), 1);
			}
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
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	private void tree(Connection conn,int id,int level) {
		Statement stmt=null;
		ResultSet rs=null;
		StringBuffer strPre=new StringBuffer("");
		for(int i=0;i<level;i++) {
			strPre.append("....");
		}
		try {
			stmt=conn.createStatement();
			String sql="select * from article where pid= "+id;
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(strPre+rs.getString("cont"));
				if(rs.getInt("isleaf")!=0)
					tree(conn, rs.getInt("id"), level+1);
			}
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
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
