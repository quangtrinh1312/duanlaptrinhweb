package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountDAO;
import DAO.DanhSachSinhVienDAO;
import Model.Account;
import Model.DoanVien;

/**
 * Servlet implementation class DssvServlet
 */

@WebServlet(urlPatterns = { "/DssvServlet", "/admin/DssvServlet" })
public class DssvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DssvServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Account a = (Account) request.getSession().getAttribute("account");
//		==================
		if(a==null) {
			AccountDAO checkAcc= new AccountDAO();
			a = checkAcc.login("trinh", "123");
			
		}
//		==================
		DanhSachSinhVienDAO dao = new DanhSachSinhVienDAO();
		int maLop=dao.getMaLopByMaSinhVien(a.getMaSinhVien());
		List<DoanVien> d = dao.getByMaLop(maLop);
		request.setAttribute("list", d);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
