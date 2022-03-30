package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
@WebServlet("/fileread")
public class ReadfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filepath=request.getParameter("filepath");
		File file = new File(filepath);
	    Scanner sc = new Scanner(file);
	    PrintWriter out=response.getWriter();
	 while (sc.hasNextLine())
	      out.println(sc.nextLine());
	    }
	}

