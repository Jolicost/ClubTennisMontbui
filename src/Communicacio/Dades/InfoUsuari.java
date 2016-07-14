package Communicacio.Dades;

import java.lang.reflect.Field;
import java.util.Map;

import Communicacio.Excepcions.DadaIncorrecta;
import Domini.Model.Usuari;


public class InfoUsuari extends Info {

	public String email;
	private String password;
	public String dni;
	public String nom;
	public String cognoms;
	public String rang;
	public String nsoci;
	
	

	public InfoUsuari(){}

	public String getEmail() {
		return email;
	}
	public void setEmail(String correu) {
		this.email = correu;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}


	public String getRang() {
		return rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}
	
	public String getNsoci() {
		return nsoci;
	}

	public void setNsoci(String nsoci) {
		this.nsoci = nsoci;
	}
	
	public InfoUsuari toInfoUsuari() throws DadaIncorrecta{
		return this;
	}
	
	public Info Populate(Map<String,String[]> params) throws IllegalArgumentException, IllegalAccessException{
		if (params.containsKey("email")) this.setEmail(params.get("email")[0]);
		if (params.containsKey("password")) this.setPassword(params.get("password")[0]);
		if (params.containsKey("dni")) this.setDni(params.get("dni")[0]);
		if (params.containsKey("nom")) this.setNom(params.get("nom")[0]);
		if (params.containsKey("cognoms")) this.setCognoms(params.get("cognoms")[0]);
		if (params.containsKey("rang")) this.setRang(params.get("rang")[0]);
		if (params.containsKey("nsoci")) this.setNsoci(params.get("nsoci")[0]);
		return this;
	}
	
	
	


	
}
