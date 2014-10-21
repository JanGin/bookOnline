package myeclipse.bookOnline.web.manage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myeclipse.bookOnline.bean.Book;
import myeclipse.bookOnline.bean.Category;
import myeclipse.bookOnline.bean.Page;
import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.service.impl.BusinessServiceImpl;
import myeclipse.bookOnline.utils.UUID_Util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
public class BookServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("addBook")){
			addBook(request,response);
		} else if (method.equals("addUI")){
			addUI(request,response);
		} else if (method.equals("listBook")){
			listBook(request,response);
		}
	}

	
	private void listBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取用户想看的页数
		String pageNum = request.getParameter("pageNum");
		BusinessService service = new BusinessServiceImpl();
		Page page = service.getPageData(pageNum);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manageJSP/listBook.jsp").forward(request, response);
	}


	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BusinessService service = new BusinessServiceImpl();
		List<Category> list = service.list();
		request.setAttribute("category", list);
		request.getRequestDispatcher("/manageJSP/addBook.jsp").forward(request, response);
	}


	private void addBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			Book book = upload(request);
			BusinessService service = new BusinessServiceImpl();
			book.setId(UUID_Util.createID());
			service.addBook(book);
			request.setAttribute("message", "添加成功！！");
			
		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "添加失败！");
	
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}


	@SuppressWarnings("unchecked")
	private Book upload(HttpServletRequest request) {
		Book book = new Book();
		try{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list){
				if (item.isFormField()){
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(book, name, value);
				} else{
					String filename = item.getName();
					String saveName = RenewFileName(filename);	//得到文件在硬盘上的文件名；
					InputStream in = item.getInputStream();
					String savePath = this.getServletContext().getRealPath("/images");		//得到保存目录
					FileOutputStream out = new FileOutputStream(savePath + "\\" + saveName); 
					int len = 0;
					byte[] buf = new byte[1024];
					while((len = in.read(buf)) > 0){
						out.write(buf,0,len);
					}
					in.close();
					out.close();
					item.delete();
					book.setImage(saveName);
				}
			}
			return book;
		} 
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	private String RenewFileName(String filename) {
		String ext = filename.substring(filename.lastIndexOf("."));
		return UUID.randomUUID().toString() + ext;
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
