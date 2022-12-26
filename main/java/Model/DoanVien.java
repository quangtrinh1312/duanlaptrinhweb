package Model;

import java.util.Date;

public class DoanVien {
	private int maSinhVien;
	private String hoTen;
	private Date ngaySinh;
	private int maLop;

	public DoanVien(int maSinhVien, String hoTen, Date ngaySinh, int maLop) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.maLop = maLop;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getMaLop() {
		return maLop;
	}

	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}

	@Override
	public String toString() {
		return "DoanVien [maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", maLop=" + maLop
				+ "]";
	}
	
}
