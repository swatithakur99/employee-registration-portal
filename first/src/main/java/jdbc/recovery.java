package jdbc;                   //Forgot password

import java.io.IOException;         
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Confirm")
public class recovery extends HttpServlet{
	static Connection con;
	int x;
	static String sql = "UPDATE emp SET pass=?  WHERE email=?";
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
        String eml=req.getParameter("email");
        String p=req.getParameter("pass");
		changePassword(eml,p);
		if(x==1) out.println("Successfully Created New Pass Key!!!");
		out.close();
	}
	protected void changePassword(String email,String pass)
	{
		try {System.out.println("OK/-");
           con = jdbc.connection.connection.getConnection();
  	     PreparedStatement ps = con.prepareStatement(sql);	
  	     ps.setString(1, pass);
	     ps.setString(2, email);
  	     ps.executeUpdate();  
  	     x=1;
        } catch (Exception e) {
           System.out.println("Connection failed"+e.toString());
        }
	}
}