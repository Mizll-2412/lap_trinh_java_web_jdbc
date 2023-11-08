package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
	//muon su dung phuong thuc findAll trong categorydao
	@Inject
	private ICategoryDAO iDao;
//	public CategoryService()
//	{
//		iDao= new CategoryDAO();
//	}
	// thi phai su dung nhu nay 
	@Override
	public List<CategoryModel> findAll() {
		return iDao.findAll();
	}

}
