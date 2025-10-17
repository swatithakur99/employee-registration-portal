package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	public static Connection con;
	public static Connection getConnection()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","");	
			}
		catch (Exception e) {
           System.out.println("Connection failed"+e.toString());
        }
		return con;
	}
}