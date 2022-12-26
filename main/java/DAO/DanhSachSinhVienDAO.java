package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import Model.DoanVien;

public class DanhSachSinhVienDAO {
	private Connection connection;
	private PreparedStatement pS;
	private ResultSet rS;
	
	public DanhSachSinhVienDAO() {
		// TODO Auto-generated constructor stub
	}
	public int getMaLopByMaSinhVien(int maSinhVien) {
		connection=ConnectDB.getConnection();
		String sql="select malop from doanvien where maSinhVien=?;";
		try {
			pS=connection.prepareStatement(sql);
			pS.setInt(1, maSinhVien);
			rS=pS.executeQuery();
			while(rS.next()) {
				return rS.getInt("maLop");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return 0;
	}
	public DoanVien getDoanVienById(int maSinhVien) {
		DoanVien t=null;
		connection=ConnectDB.getConnection();
		String sql="select * from doanvien where maSinhVien=?";
		try {
			pS=connection.prepareStatement(sql);
			pS.setInt(1, maSinhVien);
			rS=pS.executeQuery();
			while(rS.next()) {
				t=new DoanVien(rS.getInt("maSinhVien"), rS.getString("hoTen"), rS.getDate("ngaySinh"), rS.getInt("maLop"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return t;
	}
	public List<DoanVien>getByMaLop(int maLop){
		List<DoanVien>l=new ArrayList<>();
		
		connection=ConnectDB.getConnection();
		String sql="SELECT * FROM cuoikitkltweb.doanvien where maLop=?";
		try {
			pS=connection.prepareStatement(sql);
			pS.setInt(1, maLop);
			rS=pS.executeQuery();
			while(rS.next()) {
				l.add(new DoanVien(rS.getInt("maSinhVien"), rS.getString("hoTen"), rS.getDate("ngaySinh"), rS.getInt("maLop")));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return l;
	}
	
	public void DeleteDoanVien(String id) {
		connection=ConnectDB.getConnection();
		String sql="DELETE FROM `cuoikitkltweb`.`ki` WHERE  (`maSinhVien` = ?);";
		String sql1="DELETE FROM `cuoikitkltweb`.`doanvien` WHERE (`maSinhVien` = ?);";
		try(PreparedStatement delKi=connection.prepareStatement(sql);
			PreparedStatement delDoanVien=connection.prepareStatement(sql1);) {
			
			connection.setAutoCommit(false);
			delKi.setString(1, id);
			delKi.executeUpdate();
			
			delDoanVien.setString(1, id);
			delDoanVien.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void AddDoanVien(String hoTen,String ngaySinh,int maLop) {
		connection=ConnectDB.getConnection();
		String sql="INSERT INTO `cuoikitkltweb`.`doanvien` (`hoTen`, `ngaySinh`, `maLop`) VALUES (?, ?, ?);";
		try {
			pS=connection.prepareStatement(sql);
			pS.setString(1, hoTen);
			pS.setString(2, ngaySinh);
			pS.setInt(3, maLop);
			pS.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public void updateDoanVien(String hoTen, String ngaySinh,String id) {
		connection=ConnectDB.getConnection();
		String sql="UPDATE `cuoikitkltweb`.`doanvien` SET `hoTen` = ?, `ngaySinh` = ? WHERE (`maSinhVien` = ?);";
		try {
			pS=connection.prepareStatement(sql);
			pS.setString(1, hoTen);
			pS.setString(2, ngaySinh);
			pS.setString(3, id);
			pS.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		DanhSachSinhVienDAO dao=new DanhSachSinhVienDAO();
		System.out.println(dao.getMaLopByMaSinhVien(2));
		System.out.println(dao.getDoanVienById(2));
	}
}
