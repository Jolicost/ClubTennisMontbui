package Communicacio.Dades;

import Communicacio.Excepcions.DadaIncorrecta;

public class InfoCalendari extends Info {

	public int id;
	public String nom;
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
	
	public InfoCalendari toInfoCalendari() throws DadaIncorrecta{
		return this;
	}
	
}
