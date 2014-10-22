package myeclipse.bookOnline.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.bean.Cart;
import myeclipse.bookOnline.bean.User;
import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;

@SuppressWarnings("serial")
public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			User user = (User)request.getSession().getAttribute("user");
			if (user == null){
				request.setAttribute("message", "�ף����ȵ�¼���ٲ���");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			BusinessService service = new BusinessServiceImpl();
			service.createOrder(user,cart);
			request.setAttribute("message", "�ѳɹ� ���ɶ�������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "���ź�,���ɶ���ʧ��%>_<%");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
