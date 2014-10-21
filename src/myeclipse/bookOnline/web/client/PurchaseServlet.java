package myeclipse.bookOnline.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.bean.Cart;
import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;
import myeclipse.bookOnline.bean.Book;

@SuppressWarnings("serial")
public class PurchaseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String bookid = request.getParameter("bookid");
			BusinessService service = new BusinessServiceImpl();
			Book book = service.findBook(bookid);
			//获得用户的购物车
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			if (cart == null){
				cart = new Cart();
				request.getSession().setAttribute("cart", cart);
			}
			service.purchase(cart,book);
			request.getRequestDispatcher("/clientJSP/listCart.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "购买失败~~");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
