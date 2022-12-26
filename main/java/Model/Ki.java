package Model;
public class Ki {
	private int ki;
	private int maSinhVien;
	private int gia;
	public Ki(int ki, int maSinhVien, int gia) {
		super();
		this.ki = ki;
		this.maSinhVien = maSinhVien;
		this.gia = gia;
	}
	public int getKi() {
		return ki;
	}
	public void setKi(int ki) {
		this.ki = ki;
	}
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "Ki [ki=" + ki + ", maSinhVien=" + maSinhVien + ", gia=" + gia + "]";
	}
	
}
