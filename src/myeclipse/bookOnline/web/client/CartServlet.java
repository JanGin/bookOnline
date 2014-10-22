package myeclipse.bookOnline.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.bean.User;

@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		if (user == null){
			request.setAttribute("message", "Ç×£¡£¡Äú»¹Î´µÇÂ¼");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/clientJSP/listCart.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
