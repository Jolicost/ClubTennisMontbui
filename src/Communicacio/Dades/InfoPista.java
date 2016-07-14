package Communicacio.Dades;

import Communicacio.Excepcions.DadaIncorrecta;

public class InfoPista extends Info{
	public int id;
	public String nom;
	public String tipus;
	public String calendari;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
	public InfoPista toInfoPista() throws DadaIncorrecta{
		return this;
	}
	public String getCalendari() {
		return calendari;
	}
	public void setCalendari(String Calendari) {
		this.calendari = Calendari;
	}
}
