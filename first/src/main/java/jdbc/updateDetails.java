package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/change")
public class updateDetails extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String  Update= "UPDATE emp SET  name=?, desg=?, email=?, pass=? WHERE id = ?";
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {

		Connection conn = null;
		PreparedStatement stmt=null;

		String n=req.getParameter("name");
		String i= req.getParameter("id");
		String em=req.getParameter("email");
		String d=req.getParameter("desg");
		String pa=req.getParameter("pass");
		byte[] encrypt= Base64.getEncoder().encode(pa.getBytes());
		String p= new String (encrypt);
		try {
			conn =jdbc.connection.connection.getConnection();
			stmt = conn.prepareStatement(Update);
			stmt.setString(1, n);
			stmt.setString(2, d);
			stmt.setString(3, em);
			stmt.setString(4, p);
			stmt.setString(5, i );
			System.out.println("name"+n+"email"+em+"  "+d);
			int row=stmt.executeUpdate();

			if(row>0)	res.getWriter().print("Sucessfully Updated.");
			else 	res.getWriter().print("Error");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}