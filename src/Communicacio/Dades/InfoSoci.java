package Communicacio.Dades;

import java.util.Map;

import org.joda.time.LocalDate;

import Communicacio.Excepcions.DadaIncorrecta;

public class InfoSoci extends Info {
	
	public int numero;
	public String dni;
	public String nom;
	public String cognoms;
	public String quota;
	public String telefon;
	public String adreca;
	public LocalDate naixament;
	
	public InfoSoci(){
		
	}
	public InfoSoci(int numero, String dni, String nom, String quota,String cognoms) {
		super();
		this.numero = numero;
		this.dni = dni;
		this.nom = nom;
		this.quota = quota;
		this.cognoms = cognoms;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getCognoms() {
		return cognoms;
	}
	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}
	
	public InfoSoci toInfoSoci() throws DadaIncorrecta{
		return this;
	}
	@Override
	public Info Populate(Map<String, String[]> params) throws IllegalArgumentException, IllegalAccessException {
		if (params.containsKey("numero")) this.setNumero(Integer.valueOf(params.get("numero")[0]));
		if (params.containsKey("dni")) this.setDni(params.get("dni")[0]);
		if (params.containsKey("nom")) this.setNom(params.get("nom")[0]);
		if (params.containsKey("cognoms")) this.setCognoms(params.get("cognoms")[0]);
		if (params.containsKey("telefon")) this.setTelefon(params.get("telefon")[0]);
		if (params.containsKey("adreca")) this.setAdreca(params.get("adreca")[0]);
		if (params.containsKey("naixament")) {
			String naixament = params.get("naixament")[0];
			try{
				this.setNaixament(LocalDate.parse(naixament));
			}
			catch (Exception e){
				this.setNaixament(null);
			}
				
		}
		return this;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdreca() {
		return adreca;
	}
	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}
	public LocalDate getNaixament() {
		return naixament;
	}
	public void setNaixament(LocalDate naixament) {
		this.naixament = naixament;
	}
	
}
