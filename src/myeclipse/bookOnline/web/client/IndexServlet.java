package myeclipse.bookOnline.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.bean.Category;
import myeclipse.bookOnline.bean.Page;
import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;

@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("getAll")){
			getAll(request,response);
		} else if (method.equals("listBookWithCategory")){
			listBookWithCategory(request,response);
		}
		
	}

	
	//得到所有的书
	private void getAll(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException{
		
		
		String pageNum = request.getParameter("pageNum");
		BusinessService service = new BusinessServiceImpl();
		List<Category> list = service.list();
		request.setAttribute("category", list);
		Page page = service.getPageData(pageNum);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/clientJSP/body.jsp").forward(request, response);
	}

	//得到分类下的书
	private void listBookWithCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String category_id = request.getParameter("category_id");
		String pageNum = request.getParameter("pageNum");
		BusinessService service = new BusinessServiceImpl();
		Page page = service.getBookPageData(pageNum, category_id);
		request.setAttribute("category", service.list());
		request.setAttribute("page", page);
		request.getRequestDispatcher("/clientJSP/body.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
