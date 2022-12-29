package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.AccountDAO;
import DAO.DanhSachSinhVienDAO;

/**
 * Servlet implementation class AddAccountServlet
 */
@WebServlet(urlPatterns = {"/AddAccountServlet", "/admin/AddAccountServlet"})
public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String hoten=request.getParameter("hoten");
		String date=request.getParameter("date");
		String maLop=request.getParameter("maLop");
		AccountDAO aDao=new AccountDAO();
		DanhSachSinhVienDAO dao=new DanhSachSinhVienDAO();
		dao.AddDoanVien(hoten, date, Integer.parseInt(maLop));
		aDao.addAccount(name, pass,String.valueOf(dao.getLastMsv()));
		response.sendRedirect("DstkServlet");
	}

}
