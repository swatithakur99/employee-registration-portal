package jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
/* The Java file upload Servlet example */
@WebServlet(name = "upload", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class upload extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*Receive file uploaded to the Servlet from the HTML5 form*/
    Part filePart = request.getPart("file");
    Part docPart = request.getPart("file2");
    String imgName = filePart.getSubmittedFileName();
    String docName = docPart.getSubmittedFileName();
    filePart.write("C:\\Users\\aashi\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\first\\src\\main\\webapp\\image\\img\\" + imgName);
    docPart.write("C:\\Users\\aashi\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\first\\src\\main\\webapp\\image\\doc\\" + docName);  
    Connection con=null;
	try {
	 con =jdbc.connection.connection.getConnection();
		PreparedStatement stmt;
		String query="insert into image values(?,?,?)";
		stmt=con.prepareStatement(query);
		stmt.setString(1,request.getParameter("id"));
		stmt.setString(2, imgName);
		stmt.setString(3, docName);
		int row=stmt.executeUpdate();
		if(row>0)	response.getWriter().print("The file uploaded sucessfully.");
		else 	response.getWriter().print("Error");	
	}
	catch(Exception e){	e.printStackTrace();}
  }

}