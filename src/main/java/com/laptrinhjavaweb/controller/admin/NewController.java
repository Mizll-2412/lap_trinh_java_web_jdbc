package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns ={"/admin-new"})
public class NewController extends HttpServlet {

	@Inject
	private INewService newService;
	private static final long serialVersionUID = 5243934502037847728L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		NewModel newModel= FormUtil.toModel(NewModel.class, request);
		Pageble pageble =new PageRequest(newModel.getPage(), newModel.getMaxPageItem(),new Sorter(newModel.getSortName(),newModel.getSortBy() ));
		newModel.setListResult(newService.findAll(pageble));
		newModel.setTotalItems(newService.getTotalItem());
		newModel.setTotalPage((int)Math.ceil((double)newModel.getTotalItems()/newModel.getMaxPageItem()));
		request.setAttribute(SystemConstant.MODEL, newModel);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		
	}
}
