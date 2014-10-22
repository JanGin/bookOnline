package myeclipse.bookOnline.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.bean.User;
import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;
import myeclipse.bookOnline.utils.UUID_Util;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			User user = new User();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String cellphone = request.getParameter("cellphone");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			user.setId(UUID_Util.createID());
			user.setUsername(username);
			user.setPassword(password);
			user.setPhone(phone);
			user.setCellphone(cellphone);
			user.setAddress(address);
			user.setEmail(email);
			BusinessService service = new BusinessServiceImpl();
			service.registeUser(user);
			request.setAttribute("message", "πßœ≤ƒ„!◊¢≤·≥…π¶!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "∫‹“≈∫∂◊¢≤· ß∞‹£¨«Î÷ÿ ‘*^__^*");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
