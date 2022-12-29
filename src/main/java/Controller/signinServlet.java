package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SigninDAO;

/**
 * Servlet implementation class signinServlet
 */
@WebServlet("/signinServlet")
public class signinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signinServlet() {
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
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		String pass1=request.getParameter("password1");
		if(user.equals("")) {
			request.setAttribute("userErr", "*vui lòng nhập tên tài khoản");
		}
		if(pass.equals("")) {
			request.setAttribute("passErr", "*vui lòng nhập mật khẩu");
		}
		if(pass1.equals("")) {
			request.setAttribute("pass1Err", "*vui lòng nhập mật khẩu");
		}else {
			if(!pass1.equals(pass)) {
				request.setAttribute("pass1Err", "*mật khẩu không khớp");
				request.getRequestDispatcher("signin.jsp").forward(request, response);
			}
		}
		if(user.equals("")||pass.equals("")||pass1.equals("")) {
			request.getRequestDispatcher("signin.jsp").forward(request, response);
		}
		SigninDAO signin = new SigninDAO();
		Boolean a= signin.checkUserNameSignin(user, pass);
		if(!a) {
			request.setAttribute("userErr", "*tên tài khoản đã được sử dụng");
			request.getRequestDispatcher("signin.jsp").forward(request, response);
		};
		response.sendRedirect("./admin/admin.jsp");
		
	}

}
