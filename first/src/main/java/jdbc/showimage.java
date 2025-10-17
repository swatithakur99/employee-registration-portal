package jdbc;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DisplayImage")
public class showimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		String imgId=null;
		String imgfilename=null;
		String doc=null;
		String n=request.getParameter("id");
		try {
			con=jdbc.connection.connection.getConnection();
			java.sql.Statement stmt;
			String query="select * from image";
			stmt= con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery(query);
			
			while(rs.next())
			{
				if(rs.getString("id").equals(n))
				{
					imgId=rs.getString("id");
					imgfilename=rs.getString("img");
					doc=rs.getString("res");
					System.out.println(imgId);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd;
		request.setAttribute("id", imgId);
		request.setAttribute("img", imgfilename);
		request.setAttribute("docs",doc);
		rd=request.getRequestDispatcher("showImage.jsp");
		rd.forward(request, response);	
	}
}

