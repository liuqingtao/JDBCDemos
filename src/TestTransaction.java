import java.sql.*;
public class TestTransaction {

	public static void main(String[] args) {
		Connection conn=null;
		Statement smt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			conn.setAutoCommit(false); 																		//���Զ��ύ����Ϊfalse
			smt=conn.createStatement();
			smt.addBatch("insert into dept2 values(1,'Game','bj')");
			smt.addBatch("insert into dept2 values(2,'Game','bj')");
			smt.addBatch("insert into dept2 values(3,'Game','bj')");
			smt.executeBatch();
			conn.commit();																					//�ֶ������ύ 
			conn.setAutoCommit(true); 																		//���Զ��ύ���û���														  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			if(conn!=null) {
				try {
					conn.rollback();																		//�������лع�
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
