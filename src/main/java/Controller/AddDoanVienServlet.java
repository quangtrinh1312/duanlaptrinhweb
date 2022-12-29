package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountDAO;
import DAO.DanhSachSinhVienDAO;
import Model.Account;

/**
 * Servlet implementation class AddDoanVienServlet
 */

//@WebServlet(urlPatterns = {"/AddDoanVienServlet"})
@WebServlet(urlPatterns = {"/AddDoanVienServlet", "/admin/AddDoanVienServlet"})
public class AddDoanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hoTen=request.getParameter("hoTen");
		String ngaySinh=request.getParameter("ngaySinh");
		String idLop=request.getParameter("idLop");
		DanhSachSinhVienDAO dao=new DanhSachSinhVienDAO();
		dao.AddDoanVien(hoTen, ngaySinh, Integer.parseInt(idLop));
		response.sendRedirect(request.getContextPath()+"/DslopServlet?id="+idLop);
	}

}
