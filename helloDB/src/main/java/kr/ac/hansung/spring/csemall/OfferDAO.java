package kr.ac.hansung.spring.csemall;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OfferDAO {

	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}
	
	//querying and returning a single object
	public Offer getOffer(String name) {
		String sqlStatement = "select * from offers where name=?";
		
		return jdbcTemplateObject.queryForObject(sqlStatement,new Object[] {name},
				new RowMapper<Offer>());
	}
}
