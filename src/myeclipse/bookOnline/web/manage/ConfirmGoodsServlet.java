package myeclipse.bookOnline.web.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;

@SuppressWarnings("serial")
public class ConfirmGoodsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		String orderid = request.getParameter("orderid");
		BusinessService service = new BusinessServiceImpl();
		service.confirmGoods(orderid);
		request.setAttribute("message", "�Ѹ���״̬Ϊ�����������뾡�췢����ʱע��������Ϣ!!");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "ȷ�Ϸ�������,������");
			request.getRequestDispatcher("/message").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request,response);
	}

}
