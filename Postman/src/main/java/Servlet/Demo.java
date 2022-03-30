package Servlet;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/demo")
public class Demo extends HttpFilter {

	private static final long serialVersionUID = 1L;

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String Phonenumber=request.getParameter("Phonenumber");
		PrintWriter out=response.getWriter();
		String mailregex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		String nameregex = "^[\\p{L} .'-]+$";
		String pnumberregex="^[6-9]\\d{9}$";
		try{
			//chain.doFilter(request, response);
            if (!email.matches(mailregex)) {
                throw new NoSuchFieldException("email is not valid");
            }
            if (!name.matches(nameregex)) {
                throw new ArithmeticException("name is not valid");
            }
            if(!Phonenumber.matches(pnumberregex)) {
            	throw new NumberFormatException();   
            	}
            out.print("All values valid");
		}
		catch(NoSuchFieldException message) {
			out.print("<h1>email is notvalid check that</h1><ul><li>The mail adrees ends with @gmail.com</li><li>The mail address have up to 16 charactors</li><li>The mail address have any space charactor</li><li>The mail address have some speacial charactors expecte @</li></ul>");
		}
		catch(NumberFormatException message) {
			out.print(
					"<h1>The phone number is not valid check that</h1> <ul><li>The phone number contains only digits.</li><li>The phone number not contains space. </li> <li>The length of phone number not equal to 10.</li> <li>Try again</li></ul></h1>");
		}
		catch(ArithmeticException e) {
			out.println("<h1>The entered name is not valid check that</h1> <ul><li>The name contains any digits.</li><li>The name have some speacial charactors.</li> <li>The name value is not empty<li>Try again</li></ul></h1>");
		}
		catch(Exception e) {
			out.print("<h1>Sorry,Try again</h1>");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
