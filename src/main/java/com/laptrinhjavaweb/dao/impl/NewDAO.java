package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryid) {
		String sql="SELECT * FROM news where categoryid = ?";
		return query(sql, new NewMapper(), categoryid);
		}
	@Override
	public Long save(NewModel newModel) {
		//String sql="INSERT INTO news(title,content,categoryid) VALUES(?,?,?) ";
		//dung stringbuilder giup giam thieu lang phi bo nho
		StringBuilder sql= new StringBuilder("INSERT INTO news(title,content,");
		sql.append("thambnail,shortdecription,categoryid,createddate,createdby)");
		sql.append(" VALUES(?,?,?,?,?,?,?)");
		return insert(sql.toString(), newModel.getTitle(),newModel.getContent(),
				newModel.getThambnail(),newModel.getShortDecription(),newModel.getCategoryId()
				,newModel.getCreatedDate(),newModel.getCreatedBy());
	}
	@Override
	public NewModel findOne(Long id) {
		String sql="SELECT * FROM news where id = ?";
		List<NewModel> news=query(sql,new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}
	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thambnail = ?,");
		sql.append(" shortdecription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate=?, modifiedby=? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThambnail(), updateNew.getShortDecription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), 
				updateNew.getCreatedBy(), updateNew.getId(),updateNew.getModifiedDate(),updateNew.getModifiedBy());
	}
	@Override
	public void delete(long id) {
		String sql="DELETE FROM news WHERE id=?";
		update(sql, id);
	}
	@Override
	public List<NewModel> findAll(Pageble pageble) {
		//String sql="SELECT * FROM news LIMIT ?,?";
		StringBuilder sql= new StringBuilder("SELECT * FROM news");
		if(pageble.getSorter()!=null)
		{
			sql.append(" ORDER BY"+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if(pageble.getOffset()!=null && pageble.getLimit()!=null)
		{
			sql.append(" LIMIT"+pageble.getOffset()+","+pageble.getLimit()+"");
		}
		return query(sql.toString(), new NewMapper());
	}
	@Override
	public int getTotalItem() {
		String sql="SELECT count(*) FROM news";
		return count(sql);
	}
}
