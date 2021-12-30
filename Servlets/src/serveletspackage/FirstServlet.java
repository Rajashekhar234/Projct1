package serveletspackage;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/first")

public class FirstServlet implements Servlet{
	     public  void init(javax.servlet.ServletConfig sc) 
            throws javax.servlet.ServletException
            {
		        //No Code
            }

       public void service(ServletRequest req,ServletResponse res)
		throws javax.servlet.ServletException, java.io.IOException
           {
    	          Date d=new Date();
	              PrintWriter pw = res.getWriter();
	              res.setContentType("text/html");
	              pw.println("WELCOME to Servlet Programming....hello");
	              pw.print("<h1>Date and time is:::"+d+"</h1>");
	              String name=req.getParameter("uname");
	              Long phn=Long.parseLong(req.getParameter("phno"));
	              pw.println("welcome"+name);
	              pw.print("<h4>PH Number:"+phn);
	              
	              
           }
     public  void destroy()
          {
	           //NoCode
          }

       public javax.servlet.ServletConfig getServletConfig()
         {
	           return this.getServletConfig();
         }
      public  java.lang.String getServletInfo()
        {
	           return "FisrtServlet";
        }
}

