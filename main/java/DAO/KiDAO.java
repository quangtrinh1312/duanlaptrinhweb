package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import Model.DoanVien;
import Model.Ki;

public class KiDAO {
	private Connection connection;
	private PreparedStatement pS;
	private ResultSet rS;

	public KiDAO() {
		// TODO Auto-generated constructor stub
	}

	public List<Ki> getByMsv(String msv) {
		List<Ki> l = new ArrayList<>();

		connection = ConnectDB.getConnection();
		String sql = "select c.*,k.gia from chitietki c join ki k on c.ki=k.idKi where maSinhVien=?";
		try {
			pS = connection.prepareStatement(sql);
			pS.setString(1, msv);
			rS = pS.executeQuery();
			while (rS.next()) {
				l.add(new Ki(rS.getInt("ki"), rS.getInt("maSinhVien"), rS.getInt("gia")));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return l;
	}

	public List<Integer>kiChuaNop(int msv){
		List<Integer>l=new ArrayList<>();
		connection=ConnectDB.getConnection();
		String sql="select idKi from ki where idKi not in \r\n"
				+ "(select c.ki from chitietki c join ki k on c.ki=k.idKi where maSinhVien=?)";
		try {
			pS=connection.prepareStatement(sql);
			pS.setInt(1, msv);
			rS=pS.executeQuery();
			while(rS.next()) {
				l.add(rS.getInt("idKi"));
			}
		} catch (SQLException e) {
			
		}
		return l;
	}

	public static void main(String[] args) {
		KiDAO dao = new KiDAO();
		System.out.println(dao.kiChuaNop(2));
	}
}
