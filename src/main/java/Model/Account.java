package Model;

public class Account {
	private int maSinhVien;
	private String userName;
	private String passWord;
	private int role;
	public Account(int maSinhVien, String userName, String passWord, int role) {
		super();
		this.maSinhVien = maSinhVien;
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}