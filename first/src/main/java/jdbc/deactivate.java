package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Deactivate")
public class deactivate extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String id = request.getParameter("id");
    System.out.println("aaa"+id);
    
    try {
        Connection con = jdbc.connection.connection.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
        PreparedStatement ps2= con.prepareStatement("delete from image where id=? and exists (select * from image where id=?)");
        ps.setString(1, id);
        ps2.setString(1, id);
        ps2.setString(2, id);
        int i = ps.executeUpdate();
        int j= ps2.executeUpdate();
        if(i>0) {
            out.println("User successfully removed...");
        }

    } catch (Exception e) {
        System.out.println(e);
    }
}

}