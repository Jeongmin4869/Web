package kr.ac.hansung.spring.csemall;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OfferMapper implements RowMapper<Offer> {

	@Override
	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Offer offer = new Offer();

		offer.setId(rs.getInt("id"));
		offer.setName(rs.getString("name"));
		offer.setEmail(rs.getString("email"));
		offer.setText(rs.getString("text"));

		return offer;
	}

}
