package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import Model.Lop;

public class LopDAO {
	private Connection connection;
	private PreparedStatement pS;
	private ResultSet rS;
	public LopDAO() {
		// TODO Auto-generated constructor stub
	}
	public List<Lop>getAll(){
		List<Lop>l=new ArrayList<>();
		
		connection=ConnectDB.getConnection();
		String sql="SELECT * FROM cuoikitkltweb.lop";
		try {
			pS=connection.prepareStatement(sql);
			
			rS=pS.executeQuery();
			while(rS.next()) {
				l.add(new Lop(rS.getInt("maLop"), rS.getString("tenLop")));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return l;
	}
	public void addLop(String name) {
		connection=ConnectDB.getConnection();
		String sql="INSERT INTO `cuoikitkltweb`.`lop` (`tenLop`) VALUES (?);";
		try {
			pS=connection.prepareStatement(sql);
			pS.setString(1, name);
			pS.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public void editlop(String id,String name) {
		connection=ConnectDB.getConnection();
		String sql="UPDATE `cuoikitkltweb`.`lop` SET `tenLop` = ? WHERE (`maLop` = ?);";
		try {
			pS=connection.prepareStatement(sql);
			pS.setString(1, name);
			pS.setString(2, id);
			pS.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public void deleteLop(String id) {
		connection=ConnectDB.getConnection();
		String sql="DELETE FROM `cuoikitkltweb`.`lop` WHERE (`maLop` = ?);";
		try {
			pS=connection.prepareStatement(sql);
			pS.setString(1, id);
			pS.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		LopDAO dao=new LopDAO();
		System.out.println(dao.getAll());
	}
}
