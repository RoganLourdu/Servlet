package Servlet;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class filterforex extends HttpFilter {
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String Phonenumber=request.getParameter("Phonenumber");
		PrintWriter out=response.getWriter();
		String mailregex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		String nameregex = "^[\\p{L} .'-]+$";
		String pnumberregex="^[6-9]\\d{9}$";
		try{
			chain.doFilter(request, response);
            if (!email.matches(mailregex)) {
                throw new NoSuchFieldException(email+" is not valid");
            }
            if (!name.matches(nameregex)) {
                throw new NoSuchFieldException(name+" is not valid");
            }
            if(!Phonenumber.matches(pnumberregex)) {
            	throw new NumberFormatException(Phonenumber+" is not have numbers");   
            	}
            out.print("All values valid");
		}
		catch(NoSuchFieldException message) {
			out.print(message);
		}
		catch(NumberFormatException message) {
			out.print(message);
		}
		catch(Exception e) {
			out.print("Sorry,Try again");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
