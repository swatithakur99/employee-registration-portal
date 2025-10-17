package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class login extends HttpServlet{
	static Connection con;
	static String sql = "SELECT pass FROM emp where email=? and pass=?";
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
        String eml=req.getParameter("email");
		String pwd = req.getParameter("pass");
		System.out.println(eml);
		System.out.println("pass : "+pwd);	
		byte[] encrypt= Base64.getEncoder().encode(pwd.getBytes());
		String str= new String (encrypt);
		String result=checkPassword(eml,str); 
		 if(result == "valid")
		 {
			 disp after_Login = new disp();
				after_Login.doGet(req, res);
		 }
		 else if(result == "invalid"){
		out.println("invalid");
		 }
		 out.close();
	}
	protected String checkPassword(String email, String password)
	{
		String correct=new String();
		try {
           con = jdbc.connection.connection.getConnection();
  	   //  sql+=" email = ? AND password = ?";
  	     PreparedStatement ps = con.prepareStatement(sql);	
  	     ps.setString(1, email);
  	     ps.setString(2, password);
  	     System.out.println("password : "+password);
  	     ResultSet rs = ps.executeQuery();
  	   while (rs.next()) {
	         correct = rs.getString(1);
	         System.out.println("correct "+correct);
	      }   		      
        } catch (Exception e) {
            // TODO Auto-generated catch block
           System.out.println("Connection failed"+e.toString());
        }
		if(correct.equals(password))	return "valid";
		else 	return "invalid";
	}
}