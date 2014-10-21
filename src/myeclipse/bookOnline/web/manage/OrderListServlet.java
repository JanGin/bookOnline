package myeclipse.bookOnline.web.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.bean.Order;
import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;

@SuppressWarnings("serial")
public class OrderListServlet extends HttpServlet {

	/**
	 * ²é¿´¶©µ¥
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String state = request.getParameter("state");
			BusinessService service = new BusinessServiceImpl();
			List<Order> list = service.listOrder(state);
			request.setAttribute("order", list);
			request.getRequestDispatcher("/manageJSP/listOrder.jsp").forward(request, response);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
