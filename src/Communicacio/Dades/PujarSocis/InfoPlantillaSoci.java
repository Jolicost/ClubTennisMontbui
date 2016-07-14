package Communicacio.Dades.PujarSocis;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import Communicacio.Dades.Info;
import Domini.CasosUs.Controladors.PujarSocis.QuotaInvalida;

public class InfoPlantillaSoci extends Info{

	public InfoPlantillaSoci(){
		
	}
	
	private int numero;
	private String nom;
	private String cognoms;
	private String dni;
	private DateTime naixament;
	private DateTime alta;
	private String quota;
	private int titular;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public int getTitular() {
		return titular;
	}
	public void setTitular(int titular) {
		this.titular = titular;
	}
	
	public InfoPujarSoci toInfoPujarSoci() throws QuotaInvalida{
		InfoPujarSoci ret = new InfoPujarSoci();
		ret.setNumero(this.getNumero());
		ret.setNom(this.getNom());
		ret.setCognoms(this.getCognoms());
		ret.setDni(this.getDni());
		if (this.getNaixament() != null) ret.setNaixement(this.getNaixament().toLocalDate());
		if (this.getAlta() != null) ret.setAlta(this.getAlta().toLocalDate());
		ret.setQuota(this.crearQuota());
		return ret;
	}
	
	
	private InfoQuota crearQuota() throws QuotaInvalida{
		switch(this.quota.trim().toLowerCase()){
		case("f"):{
			if (this.titular == 0){
				return new InfoQuotaTitular();
			}
			else{
				InfoQuotaMembre im = new InfoQuotaMembre();
				im.setTitular(this.titular);
				return im;
			}
		}
		case("i"):{
			return new InfoQuotaIndividual();
		}
		}
		throw new QuotaInvalida();
	}
	public DateTime getNaixament() {
		return naixament;
	}
	public void setNaixament(DateTime naixament) {
		this.naixament = naixament;
	}
	public DateTime getAlta() {
		return alta;
	}
	public void setAlta(DateTime alta) {
		this.alta = alta;
	}
}
