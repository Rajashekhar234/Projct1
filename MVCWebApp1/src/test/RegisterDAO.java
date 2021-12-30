package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


public class RegisterDAO {

	 public int k=0;

	int register(HttpServletRequest req)
	{
		try {
		@SuppressWarnings("static-access")
		Connection con = new DBConnection().getCon();		
			PreparedStatement ps=con.prepareStatement("insert into UserReg31 values(?,?,?,?,?,?,?)");
			ps.setString(1,req.getParameter("uname"));
			ps.setString(2,req.getParameter("pword"));
			ps.setString(3,req.getParameter("fname"));
			ps.setString(4,req.getParameter("lname"));
			ps.setString(5,req.getParameter("addr"));
			ps.setString(6,req.getParameter("phno"));
			ps.setString(7,req.getParameter("email"));
			
			 k=ps.executeUpdate();
			
		} catch(Exception e) {e.printStackTrace();
		}
		return k;
		 
		
		

	}
}
