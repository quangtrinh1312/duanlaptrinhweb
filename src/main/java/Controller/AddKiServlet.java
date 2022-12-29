package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KiDAO;
import Model.Account;

/**
 * Servlet implementation class AddKiServlet
 */
@WebServlet(urlPatterns = { "/AddKiServlet", "/admin/AddKiServlet" })
public class AddKiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddKiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msv=request.getParameter("msv");
		KiDAO dao=new KiDAO();
		request.setAttribute("list", dao.kiChuaNop(Integer.parseInt(msv)));
		request.getRequestDispatcher("admin/themki.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] ki= request.getParameterValues("ki");
		String msv= request.getParameter("msv");
		System.out.println(msv);
		KiDAO dao= new KiDAO();
		if(ki!= null) {
			for(int i=0;i<ki.length;i++){
				dao.addKiDaNop(ki[i],msv);
			}
			Account a = (Account) request.getSession().getAttribute("account");
			if(a.getRole()==1) {response.sendRedirect("LChiServlet");}
			else {
				response.sendRedirect("DssvServlet");
			}
			
		}
		else {
			Account a = (Account) request.getSession().getAttribute("account");
			if(a.getRole()==1) {response.sendRedirect("LChiServlet");}
			else {
				response.sendRedirect("DssvServlet");
			}
		}
	}

}
