package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg2")
public class RegServlet2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sct = req.getServletContext();
		UserBean ub=(UserBean)sct.getAttribute("Uobj");
		   ub.setAddr(req.getParameter("addr"));
		   ub.setPhno(Long.parseLong(req.getParameter("phno")));
		   ub.setmId(req.getParameter("mid"));
		   int k=new RegDAO().registration(ub);
		   if(k>0)
		   {
			   pw.print("registration succesful");
			   RequestDispatcher rd=req.getRequestDispatcher("login.html");
			   rd.include(req,res);
		   }
		   else 
		   {
			   pw.println("not rgisterd");
			   RequestDispatcher rd=req.getRequestDispatcher("reg1.html");
			   rd.include(req,res);
		   }

		
		
	}
	

}
