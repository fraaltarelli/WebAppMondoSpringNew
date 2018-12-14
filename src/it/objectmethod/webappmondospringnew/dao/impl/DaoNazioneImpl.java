package it.objectmethod.webappmondospringnew.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//import it.objectmethod.webappmondospringnew.config.ConnectionManager;
import it.objectmethod.webappmondospringnew.dao.IDaoNazione;
import it.objectmethod.webappmondospringnew.model.Nazione;

public class DaoNazioneImpl extends NamedParameterJdbcDaoSupport implements IDaoNazione{	
	
	@Override
	public List<String> getAllContinents() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT distinct continent FROM country";
		list = getJdbcTemplate().queryForList(sql, String.class);	
		return list;
	}
	
	
	@Override
	public List<Nazione> getNationsByContinent(String continente) {
		List<Nazione> list = new ArrayList<Nazione>();
		String sql = "SELECT * from country where continent= :cont";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("cont", continente);
		BeanPropertyRowMapper<Nazione> rm = new BeanPropertyRowMapper<Nazione>(Nazione.class);
		list = getNamedParameterJdbcTemplate().query(sql, params, rm);
		return list;
	}
	
	
	@Override
	public List<Nazione> allNations() {
		List<Nazione> list = new ArrayList<Nazione>();
		String sql = "SELECT * from country";
		BeanPropertyRowMapper<Nazione> rm = new BeanPropertyRowMapper<Nazione>(Nazione.class);
		list = getJdbcTemplate().query(sql, rm);
		return list;
	}


}
