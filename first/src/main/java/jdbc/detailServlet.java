package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Submit")
public class detailServlet extends HttpServlet{

    //create the query
    private static final String INSERT_QUERY ="INSERT INTO emp(name,id,desg,email,pass) VALUES(?,?,?,?,?)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set Content type
        res.setContentType("text/hmtl");
        //read the form values
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String desg = req.getParameter("desg");
        String email = req.getParameter("email");
        String pass= req.getParameter("pass");

        String p= setpass(pass);
        //create the connection
        try(Connection con = jdbc.connection.connection.getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
            //set the values
            ps.setString(1, name);
            ps.setString(2, id);
            ps.setString(3, desg);
            ps.setString(4, email);
            ps.setString(5, p);                                                                                                                                                                                                                                 
            //execute the query
            int count = ps.executeUpdate();
            if(count==0) {
                pw.println("Record not stored into database");
            }else {
                pw.println("Record Stored into Database");
            }
        }catch(SQLException se) {
            pw.println(se.getMessage());
            se.printStackTrace();
        }catch(Exception e) {
            pw.println(e.getMessage());
            e.printStackTrace();
        }

        //close the stream
        pw.close();
    }
    private String setpass(String pass) {
    	    byte[] encrypt= Base64.getEncoder().encode(pass.getBytes());
    		String str= new String (encrypt);
    	    System.out.println("Plain-text password: " + pass);  
    	    System.out.println("Encrypted password using MD5: " + str);
    		return str;
    } 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }
}

