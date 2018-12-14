package it.objectmethod.webappmondospringnew.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//import it.objectmethod.webappmondospringnew.config.ConnectionManager;
import it.objectmethod.webappmondospringnew.dao.IDaoCitta;
import it.objectmethod.webappmondospringnew.model.Citta;

public class DaoCittaImpl extends NamedParameterJdbcDaoSupport implements IDaoCitta{
	
//	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplateObject;
//	
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//	}
	
	@Override
	public List<Citta> getCitiesByNation(String countrycode) {
		List<Citta> list = new ArrayList<Citta>();
		String sql = "SELECT * from city where countrycode= :countrycode";
		BeanPropertyRowMapper<Citta> rm = new BeanPropertyRowMapper<Citta>(Citta.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("countrycode", countrycode);
		list = this.getNamedParameterJdbcTemplate().query(sql, params, rm);	
		return list;
	}

	@Override
	public List<Citta> cercaCitta(String cittaCercata) {
		List<Citta> list = new ArrayList<Citta>();
		String sql = "SELECT * from city where name like :cittacercata";
		BeanPropertyRowMapper<Citta> rm = new BeanPropertyRowMapper<Citta>(Citta.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("cittacercata", cittaCercata+"%");
		list = this.getNamedParameterJdbcTemplate().query(sql, params, rm);
		return list;
	}
	
	@Override
	public void eliminaCitta(int idCitta) {
		String sql = "DELETE from city WHERE id= :idCitta";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idCitta", idCitta);
		this.getNamedParameterJdbcTemplate().update(sql, params);
		return;
	}
	
	@Override
	public void aggiornaCitta(Citta cittaDaAggiornare) {
		String sql = "UPDATE city " + 
				" SET name= :name, countrycode= :countrycode, district= :district, population= :population" + 
				" WHERE id= :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", cittaDaAggiornare.getName());
		params.addValue("countrycode", cittaDaAggiornare.getCountryCode());
		params.addValue("district", cittaDaAggiornare.getDistrict());
		params.addValue("population", cittaDaAggiornare.getPopulation());
		params.addValue("id", cittaDaAggiornare.getId());
		this.getNamedParameterJdbcTemplate().update(sql, params);
	}
	
	@Override
	public Citta cittaDaModificare(int id) {
		Citta city= new Citta();
		String sql = "SELECT * from city where id = :id";
		BeanPropertyRowMapper<Citta> rm = new BeanPropertyRowMapper<Citta>(Citta.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		city = this.getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
	    return city;
	}
	
	@Override
	public void inserisciCitta(Citta cittaDaInserire) {
		String sql = "INSERT INTO city (id, Name, CountryCode, District, Population)" + 
				" values (:id, :name, :countrycode, :district, :population)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", cittaDaInserire.getId());
		params.addValue("name", cittaDaInserire.getName());
		params.addValue("countrycode", cittaDaInserire.getCountryCode());
		params.addValue("district", cittaDaInserire.getDistrict());
		params.addValue("population", cittaDaInserire.getPopulation());
		
		this.getNamedParameterJdbcTemplate().update(sql, params);
	}

}
