package myeclipse.bookOnline.web.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import myeclipse.bookOnline.bean.Order;
import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;

@SuppressWarnings("serial")
public class OrderDetailServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String orderid = request.getParameter("orderid");
		BusinessService service = new BusinessServiceImpl();
		Order order = service.findOrder(orderid);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/manageJSP/orderDetail.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	
	}

}
