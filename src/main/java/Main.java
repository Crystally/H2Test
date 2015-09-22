import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;


public class Main {
	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/WTF", "sa", "");

		Statement stmt = conn.createStatement();
		try {
			stmt.execute("create table Foo (ID VARCHAR(36), NAME VARCHAR)");
			//用 try-catch 來解決重複 create table 的問題 [逃]
		} catch (Exception e) {}
		
		stmt.execute("insert into Foo values ('" + UUID.randomUUID().toString() + "', 'Blahblah')");
		ResultSet rs = stmt.executeQuery("select * from Foo");
		while(rs.next()) {
			System.out.println(rs.getString("id") + "\t" + rs.getString("name"));
		}
		conn.close();
	}
}
