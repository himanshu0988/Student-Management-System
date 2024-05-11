package in.JDBC.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUtil {
	
	private jdbcUtil()
	{
		
	}

		static
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() throws SQLException, IOException
		{
			FileInputStream f=new FileInputStream("C:\\Users\\HIMANSHU\\eclipse-workspace\\StudentManagementSystem\\src\\in\\JDBC\\util\\application.properties");
			Properties p=new Properties();
			p.load(f);
			
			Connection connection=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
			return connection;
		}
		public static void clenUp(Connection c,Statement s, ResultSet r) throws SQLException
		{
			if(c!=null)
			{
				c.close();
			}
			if(s!=null)
			{
				s.close();
			}
			if(r!=null)
				r.close();
		}
		


}
