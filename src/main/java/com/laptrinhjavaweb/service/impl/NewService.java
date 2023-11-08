package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.dao.impl.NewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService {
	 
	private INewDAO newDAo;
	public NewService() 
	{
		newDAo= new NewDAO();
	}
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryid) {
		return newDAo.findByCategoryId(categoryid);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long newId=newDAo.save(newModel);
		return newDAo.findOne(newId);
	}

	@Override
	public NewModel update(NewModel newModel) {
		NewModel oldNew=newDAo.findOne(newModel.getId());
		newModel.setCreatedDate(oldNew.getCreatedDate());
		newModel.setCreatedBy(oldNew.getCreatedBy());
		newModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newDAo.update(newModel);
		return newDAo.findOne(newModel.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id:ids)
		{
			//xoa comment truoc
			//sau do moi xoa bai viet
			newDAo.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {	
		return newDAo.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		int a=newDAo.getTotalItem();
		return a;
	}
	
}
