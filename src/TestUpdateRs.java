import java.sql.*;


public class TestUpdateRs {

	public static void main(String[] args) {
		try {
			new  oracle.jdbc.driver.OracleDriver();
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,									//设置为可滚动
					ResultSet.CONCUR_UPDATABLE);																	//设置为可更新
			ResultSet rs=smt.executeQuery(
					"select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp2");								//不能使用select *		
			rs.next();
			//更新一行数据
			rs.updateString("ename","AAAA");
			rs.updateRow();
			//插入新行
			rs.moveToInsertRow();
			rs.updateInt(1,9999);
			rs.updateString("ename","AAAA");
			rs.updateInt("mgr",7839);
			rs.updateDouble("sal",99.99);
			rs.insertRow();
			//将光标移动到新建的行
			rs.moveToCurrentRow();
			//删除行
			rs.absolute(5);
			rs.deleteRow();
			
			//取消更新
			//rs.cancelRowUpdates();
			rs.close();
			smt.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
