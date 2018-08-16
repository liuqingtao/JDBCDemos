import java.sql.*;
public class TestScroll {

	public static void main(String[] args) {
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,									//设置结果集为只读滚动的
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=smt.executeQuery("select * from emp order by sal");
			rs.next();
			System.out.println(rs.getInt(1));	                                                                   //获得第一个字段的值
			rs.last();
			System.out.println(rs.getString(1));
			System.out.println(rs.isLast());
			System.out.println(rs.isAfterLast());
			System.out.println(rs.getRow());
			rs.previous();	
			System.out.println(rs.getInt(1));
			rs.absolute(6);																						
			System.out.println(rs.getInt(1));
			rs.close();
			smt.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
