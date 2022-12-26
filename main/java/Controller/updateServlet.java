package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DanhSachSinhVienDAO;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet(urlPatterns = {"/updateServlet","/admin/updateServlet"})
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id= request.getParameter("id");
		DanhSachSinhVienDAO dao=new DanhSachSinhVienDAO();
		request.setAttribute("doanvien", dao.getDoanVienById(Integer.parseInt(id)));
		request.getRequestDispatcher("admin/formupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String hoTen=request.getParameter("hoTen");
		String ngaySinh=request.getParameter("ngaySinh");
		DanhSachSinhVienDAO dao=new DanhSachSinhVienDAO();
		dao.updateDoanVien(hoTen, ngaySinh, id);
		response.sendRedirect("DssvServlet");
	}

}
