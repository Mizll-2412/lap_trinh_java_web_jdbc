package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findByCategoryId(Long categoryid);
	Long save(NewModel newModel);
	NewModel findOne(Long id);
	void update(NewModel updateModel);
	void delete(long id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
