package in.student.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	// restrict the object creation from outside of class
	private JdbcUtil(){}
	static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() throws SQLException, IOException {
			
			FileInputStream fis=new FileInputStream("C:\\Users\\HIMANSHU\\eclipse-workspace\\StudentManagementSystem\\src\\in\\student\\connection\\application.properties");
			Properties properties=new Properties();
			properties.load(fis);
			
			Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
			return connection;
		}
		
		public static void clenUp(Connection connection,Statement statement, ResultSet resultset) throws SQLException {
			if(connection!=null)
				connection.close();
	
			if(statement!=null)
				statement.close();
			
			if(resultset!=null)
				resultset.close();
		}
}
