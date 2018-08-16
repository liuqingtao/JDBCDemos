import java.sql.*;
public class TestPrepStmt {

	public static void main(String[] args) {
		if(args.length!=3) {
			System.out.println("args error!");
			System.exit(-1);
		}
		int deptno=0;
		try {
			deptno=Integer.parseInt(args[0]);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		String dName=args[1];
		String loc=args[2];

		Connection conn=null;
		PreparedStatement presmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott","tiger");
			presmt=conn.prepareStatement("insert into dept2 values(?,?,?)");
			presmt.setInt(1,deptno);
			presmt.setString(2,dName);
			presmt.setString(3, loc);
			presmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
