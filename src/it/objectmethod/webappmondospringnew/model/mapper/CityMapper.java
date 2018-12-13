package it.objectmethod.webappmondospringnew.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.webappmondospringnew.model.Citta;

public class CityMapper  implements RowMapper<Citta>{

	@Override
	public Citta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Citta citta = new Citta();
		citta.setId(rs.getInt("id"));
		citta.setName(rs.getString("name"));
		citta.setDistrict(rs.getString("district"));
		citta.setPopulation(rs.getInt("population"));
		citta.setCountryCode(rs.getString("countrycode"));
		return citta;
	}
}
