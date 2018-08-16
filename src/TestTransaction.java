import java.sql.*;
public class TestTransaction {

	public static void main(String[] args) {
		Connection conn=null;
		Statement smt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			conn.setAutoCommit(false); 																		//自动提交设置为false
			smt=conn.createStatement();
			smt.addBatch("insert into dept2 values(1,'Game','bj')");
			smt.addBatch("insert into dept2 values(2,'Game','bj')");
			smt.addBatch("insert into dept2 values(3,'Game','bj')");
			smt.executeBatch();
			conn.commit();																					//手动进行提交
			conn.setAutoCommit(true); 																		//恢复现场														  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			if(conn!=null) {
				try {
					conn.rollback();																		//回滚
					conn.setAutoCommit(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		}finally {
			try {
				if(smt!=null) {
					smt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
