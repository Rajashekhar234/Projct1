package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;

public class LoginDAO {
	public String fname;
	public String login(ServletRequest req){
	try {Connection con=ConnectionDAO.getCon();
	PreparedStatement ps=con.prepareStatement("select*from reg31 where uName=? and pWord=?");
	ps.setString(1,req.getParameter("uname"));
	ps.setString(2,req.getParameter("pwrd"));
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		fname=rs.getString(3);
	}
	
}
	catch(Exception e)
	{e.printStackTrace();}
	return fname;
}
}
