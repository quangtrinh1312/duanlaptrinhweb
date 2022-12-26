package Model;

public class Lop {
	private int maLop;
	private String tenLop;
	public Lop(int maLop, int maSinhVien, String tenLop) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
	}
	public int getMaLop() {
		return maLop;
	}
	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	
}
