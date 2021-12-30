package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	public int k=0;
	private static final long serialVersionUID = 1L;  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		k=new RegisterDAO().register(request);
		if(k>0)
		{
			String fname =request.getParameter("fname");
			this.getServletContext().setAttribute("fname", fname);
			request.getRequestDispatcher("Reg.jsp").forward(request, response);
			
		}
		else
		{
			request.getRequestDispatcher("Invalid.jsp").forward(request, response);
		}
		
	     	
	}

}
