import java.sql.*;


public class TestUpdateRs {

	public static void main(String[] args) {
		try {
			new  oracle.jdbc.driver.OracleDriver();
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,									//���ù���������
					ResultSet.CONCUR_UPDATABLE);																	//���ø���ʱ��д
			ResultSet rs=smt.executeQuery(
					"select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp2");								//����ʹ��select *		
			rs.next();
			//����һ������
			rs.updateString("ename","AAAA");
			rs.updateRow();
			//��������
			rs.moveToInsertRow();
			rs.updateInt(1,9999);
			rs.updateString("ename","AAAA");
			rs.updateInt("mgr",7839);
			rs.updateDouble("sal",99.99);
			rs.insertRow();
			//������ƶ����½���
			rs.moveToCurrentRow();
			//ɾ����
			rs.absolute(5);
			rs.deleteRow();
			
			//ȡ������
			//rs.cancelRowUpdates();
			rs.close();
			smt.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
