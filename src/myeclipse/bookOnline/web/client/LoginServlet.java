package myeclipse.bookOnline.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.bean.User;
import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BusinessService service = new BusinessServiceImpl();
		User user = service.findUser(username, password);
		if (user == null){
			request.setAttribute("message", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ!!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("/clientJSP/head.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
