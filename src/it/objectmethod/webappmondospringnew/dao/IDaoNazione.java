package it.objectmethod.webappmondospringnew.dao;

import java.util.List;

import it.objectmethod.webappmondospringnew.model.Nazione;

public interface IDaoNazione {

	public List<String> getAllContinents();
	public List<Nazione> getNationsByContinent(String continent);
	public List<Nazione> allNations();
}
