package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegDAO {
	public int k=0;
	public int registration(UserBean ub)
	{
		Connection con=ConnectionDAO.getCon();
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into reg31 values(?,?,?,?,?,?,?)");
			ps.setString(1,ub.getuName());
			ps.setString(2,ub.getpWord());
			ps.setString(3, ub.getfName());
			ps.setString(4,ub.getlName());
    		ps.setString(5,ub.getAddr());
    		ps.setLong(6,ub.getPhno());
    		ps.setString(7,ub.getmId());
    		k= ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
		
	}

}
