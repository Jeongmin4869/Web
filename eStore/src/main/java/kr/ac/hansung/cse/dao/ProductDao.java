package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Product;

@Repository
public class ProductDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Product> getProducts(){
		String sqlStatement = "select * from product"; // record���¸� object�� ��Ī
		return jdbcTemplate.query(sqlStatement,new RowMapper<Product>() {
			
			
		});
	}
}
