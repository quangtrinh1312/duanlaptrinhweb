package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KiDAO;
import Model.Ki;

/**
 * Servlet implementation class KiServlet
 */
@WebServlet(urlPatterns = { "/KiServlet", "/admin/KiServlet" })
public class KiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msv=request.getParameter("msv");
		KiDAO dao=new KiDAO();
		List<Ki>list=dao.getByMsv(msv);
		PrintWriter out=response.getWriter();
//		out.print(dao.get);
		for(int i=0;i<list.size();i++) {
			out.print("<tr>\r\n"
					+ "	<td>"+list.get(i).getKi()+"</td>\r\n"
					+ "	<td>"+list.get(i).getGia()+"</td>\r\n"
					+ "</tr>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
