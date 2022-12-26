package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import Connection.ConnectDB;
import Model.Account;

public class AccountDAO {
	private Connection connection=null;
	private PreparedStatement pS= null;
	private ResultSet rS=null;
	
	public AccountDAO() {
		// TODO Auto-generated constructor stub
	}

	public Account login(String userName,String password) {
		
		Account a=null;	
		String sql="SELECT * FROM account where userName = ? and password=?";
		try {
			connection=ConnectDB.getConnection();
			pS=connection.prepareStatement(sql);
			pS.setString(1, userName);
			pS.setString(2, password);
			rS=pS.executeQuery();
			if(rS.next()) {
				a=new Account(rS.getInt("maSinhVien"), rS.getString("password"), rS.getString("userName"), rS.getInt("role"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}
