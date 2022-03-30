package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail=request.getParameter("mail");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mail ","root","");
		     PreparedStatement ps = con.prepareStatement("Select * from details where pmail=?");
		    ps.setString(1,mail	);
		    PrintWriter out=response.getWriter();
		  ResultSet rs=ps.executeQuery();
		  if(rs.next()) 
			  out.println("The email ID is present");
		  else 
			  out.println("The email ID is not present");
			  
		}
		catch (Exception e){
			out.println("try again");
		}
	}

}
