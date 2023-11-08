package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

@WebServlet(urlPatterns = { "/home" ,"/login","/logout"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -8153226337762464551L;
	ResourceBundle mybundle= ResourceBundle.getBundle("message");
	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newService;
	
	@Inject
	private IUserService userService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Long categoryid = 1L;
//		request.setAttribute("news", newService.findByCategoryId(categoryid));
	
		//test
//		String title="bài viết 5";
//		String content="daylabaiviet";
		Long id =7L;
		NewModel newModel= new NewModel();
//		newModel.setCategoryId(categoryId);
//		newModel.setTitle(title);
//		newModel.setContent(content);
		newModel.setId(id);
		String message =request.getParameter("message");
		String alert = request.getParameter("alert");
		if(message!=null&& alert!=null)
		{
			request.setAttribute("message",mybundle.getString(message));
			request.setAttribute("alert",alert);
		}
		String action=request.getParameter("action");
		if(action!=null && action.equals("login"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}else if(action!=null && action.equals("logout"))
		{
			SessionUtil.getInstance().removeValue(request,"USERMODEL");
			response.sendRedirect(request.getContextPath()+"/home");
		}
		else
		{
			request.setAttribute("categorys", categoryService.findAll());
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("login"))
		{
			UserModel user= FormUtil.toModel(UserModel.class, request);
			user= userService.findByUserNameAndPasswordAndStatus(user.getUserName(), user.getPassword(), 1);
			if(user!=null)
			{
				SessionUtil.getInstance().putValue(request,"USERMODEL",user);
				if(user.getRole().getCode().equals("USER"))
				{
					response.sendRedirect(request.getContextPath()+"/home");
				}
				else if(user.getRole().getCode().equals("ADMIN"))
				{
					response.sendRedirect(request.getContextPath()+"/admin-home");
				}
			}else
			{
				//sendRedirect:để redirect tới 1 controller nào đó ví dụ không có username and pass redirect tới trang đăng nhập
				response.sendRedirect(request.getContextPath()+"/login?action=login&message=username_password_invalid&alert=danger");
			}
			
		}
	}
}
