package Model;

public class Lop {
	private int maLop;
	private String tenLop;
	public Lop(int maLop, String tenLop) {
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
	@Override
	public String toString() {
		return "Lop [maLop=" + maLop + ", tenLop=" + tenLop + "]";
	}
	
}
