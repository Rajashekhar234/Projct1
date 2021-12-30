package login;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/reg1")
public class RegServlet1 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     UserBean ub=new UserBean();
	     ub.setuName(req.getParameter("uname"));
	     ub.setpWord(req.getParameter("pword"));
		  ub.setfName(req.getParameter("fname"));
		  ub.setlName(req.getParameter("lname"));
		  ServletContext sct = this.getServletContext();
		  sct.setAttribute("Uobj",ub);
		  RequestDispatcher rd=req.getRequestDispatcher("reg2.html");
				  rd.forward(req, res);
	}
	

}
