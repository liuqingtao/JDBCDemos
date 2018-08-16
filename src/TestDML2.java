import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class TestDML2 {

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
		String Loc=args[2];

		Connection conn=null;
		Statement smt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott","tiger");
			String sql="insert into dept2 values ("+deptno+",'"+dName+"','"+Loc+"')";
			System.out.println(sql);
			smt=conn.createStatement();
			smt.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
