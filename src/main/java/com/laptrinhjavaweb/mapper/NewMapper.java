package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultset) {
		try {
			NewModel news = new NewModel();
			news.setId(resultset.getLong("id"));
			news.setTitle(resultset.getString("title"));
			news.setContent(resultset.getString("content"));
			news.setCategoryId(resultset.getLong("categoryid"));
			news.setThumbnail(resultset.getString("thambnail"));
			news.setShortDecription(resultset.getString("shortdecription"));
			news.setCreatedDate(resultset.getTimestamp("createddate"));
			news.setCreatedBy(resultset.getString("createdby"));
			if(resultset.getTimestamp("modifieddate")!= null)
			{
				news.setModifiedDate(resultset.getTimestamp("modifieddate"));
			}
			if(resultset.getTimestamp("modifiedby")!= null)
			{
				news.setModifiedBy(resultset.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
