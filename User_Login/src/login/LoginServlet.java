package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=new LoginDAO().login(req);
		if(name==null)
		{
			   pw.println("Invalid UserName or Password...<br>");
			   RequestDispatcher rd = req.getRequestDispatcher("login.html");
			   rd.include(req,res);

		}
		else 
		{
			   pw.println("Login Successfull...<br>");
			   pw.println("WECOME "+name);

		}
		
	}

}
