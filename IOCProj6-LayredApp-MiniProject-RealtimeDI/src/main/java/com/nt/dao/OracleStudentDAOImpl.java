package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("oraStudDAO")
//@Primary
public class OracleStudentDAOImpl implements IStudentDAO {
	private static  final String   INSERT_STUDENT_QUERY="INSERT INTO FS_LAYERED_STUDENT VALUES(FS_SNO_SEQ.NEXTVAL,?,?,?,?,?)";
	// HAS-A property
	@Autowired
	private DataSource ds;
	

	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			//get Poold JDBC con object from jdbc con pool
			con=ds.getConnection();
			//create PreparedSTatement having SQL query as the pre-compiled SQL query
			ps=con.prepareStatement(INSERT_STUDENT_QUERY);
			//set values to Query params by collecting from BO class obj
			ps.setString(1,bo.getSname());
			ps.setString(2, bo.getSadd());
			ps.setInt(3, bo.getTotal());
			ps.setFloat(4, bo.getAvg());
			ps.setString(5, bo.getResult());
			//execute  the Query
			 result=ps.executeUpdate();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se; //Exception rethrowing 
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; //Exception rethrowing
		}
		finally {
			//close jdbc objs
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		return result;
	}//method

}//c;ass
