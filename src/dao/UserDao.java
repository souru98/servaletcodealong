package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.user;
import utility.ConnectionManager;

public class UserDao implements UserDaoInterface{

	@Override
	public int signup(user user) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String INSERT_USERS_SQL="INSERT INTO USERS(email,password)VALUES(?,?)";
		int result=0;
		try {
			Connection con =ConnectionManager.getConnection();
		    PreparedStatement ps = con.prepareStatement(INSERT_USERS_SQL);
		    ps.setString(1, user.getEmail());
		    ps.setString(2, user.getPassword());
		    System.out.println(ps);
		    result=ps.executeUpdate();
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean loginUser(user user) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from USERS where email=? and password=?");
			ps.setString(1, user.getEmail());
		    ps.setString(2, user.getPassword());
		    System.out.println(ps);
		    ResultSet rs=ps.executeQuery();
		    status=rs.next();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	
	

}
