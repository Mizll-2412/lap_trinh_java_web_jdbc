package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryid);
	NewModel save(NewModel newModel);
	void delete(long[] ids);
	NewModel update(NewModel newModel);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
