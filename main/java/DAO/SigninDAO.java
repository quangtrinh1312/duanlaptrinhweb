package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.protocol.Resultset;

import Connection.ConnectDB;
import Model.Account;

public class SigninDAO {
	private Connection connection=null;
	private PreparedStatement pS=null;
	private ResultSet rS=null;
	public boolean checkUserNameSignin(String userName,String password) {
		String sql="SELECT userName FROM account where userName = ?";
		try {
			connection=ConnectDB.getConnection();
			pS=connection.prepareStatement(sql);
			pS.setString(1, userName);
			rS=pS.executeQuery();
			if(!rS.next()) {
				sql="INSERT INTO `cuoikitkltweb`.`account` (`password`, `userName`, `role`) VALUES (?, ?, ?);";
				pS=connection.prepareStatement(sql);
				pS.setString(1, password);
				pS.setString(2, userName);
				pS.setInt(3, 0);
				pS.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		SigninDAO signinDAO=new SigninDAO();
		signinDAO.checkUserNameSignin("a", "123");
	}
}