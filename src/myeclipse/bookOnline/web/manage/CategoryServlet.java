package myeclipse.bookOnline.web.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;
import myeclipse.bookOnline.utils.UUID_Util;
import myeclipse.bookOnline.bean.Category;

@SuppressWarnings("serial")
public class CategoryServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		if (method.equals("add")){
			add(request,response);
				
		}else if (method.equals("delete")){
			
		}
		else if (method.equals("update")) {

		} else if (method.equals("find")) {
			
			
		} else if (method.equals("list")) {

			list(request,response);
		}else{
			request.setAttribute("message", "不支持该项操作");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	/*
	 * 查看分类
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessService service = new BusinessServiceImpl();
		List<Category> list = service.list();
		request.setAttribute("category", list);
		request.getRequestDispatcher("/manageJSP/listCategory.jsp").forward(request, response);
	}

	/*
	 * 添加分类
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			String name = request.getParameter("name");
			String description  = request.getParameter("description");
			Category category = new Category();
			category.setId(UUID_Util.createID());
			category.setName(name);
			category.setDescription(description);
			BusinessService service = new BusinessServiceImpl();
			service.add(category);
			request.setAttribute("message", "添加成功!");	

		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	
	
	
	
	
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
