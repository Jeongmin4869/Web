package kr.ac.hansung.spring.csemall;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	// querying and returning a single object
	public Offer getOffer(String name) {
		String sqlStatement = "select * from offers";

		return jdbcTemplateObject.queryForObject(sqlStatement, 
				new RowMapper<Offer>() {
						@Override
						public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
							
							Offer offer = new Offer();
							
							offer.setId(rs.getInt("id"));
							offer.setName(rs.getString("name"));
							offer.setEmail(rs.getString("email"));
							offer.setText(rs.getString("text"));
							
							return offer;
						}
		});
	}
}
