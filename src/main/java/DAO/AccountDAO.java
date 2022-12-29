package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Account> getListAccount(){
		List<Account> acc = new ArrayList<>();
		connection=ConnectDB.getConnection();
		String sql="SELECT * FROM cuoikitkltweb.account where role=0";
		try {
			pS=connection.prepareStatement(sql);
			rS=pS.executeQuery();
			while(rS.next()) {
				acc.add(new Account(rS.getInt("maSinhVien"), rS.getString("username"), rS.getString("password"), rS.getInt("role")));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return acc;
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
	public void addAccount(String usename,String password,String msv) {
		connection=ConnectDB.getConnection();
		String sql="INSERT INTO account(`maSinhVien`,`userName`, `password`, `role`) VALUES (?,?, ?, ?)";
		try {
			pS=connection.prepareStatement(sql);
			pS.setString(1, msv);
			pS.setString(2, usename);
			pS.setString(3, password);
			pS.setInt(4, 0);
			pS.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public void editAccount(String id,String username,String password) {
		connection=ConnectDB.getConnection();
		String sql="UPDATE `cuoikitkltweb`.`account` SET `userName` = ?, `password` = ? WHERE (`maSinhVien` = ?)";
		try {
			pS=connection.prepareStatement(sql);
			pS.setString(1, username);
			pS.setString(2, password);
			pS.setString(3, id);
			pS.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public void deleteAccount(String msv) {
		connection=ConnectDB.getConnection();
		String sql="DELETE FROM `account` WHERE (`maSinhVien` = ?);";
		try {
			pS=connection.prepareStatement(sql);
			pS.setString(1, msv);
			pS.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		AccountDAO dao=new AccountDAO();
//		dao.addAccount("a", "123");
	}
}
