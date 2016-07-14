package Communicacio.Dades.Reserves;

import Communicacio.Dades.InfoLapse;
import Communicacio.Excepcions.DadaIncorrecta;

public class InfoFranja extends InfoLapse {


	public InfoFranja() {
		super();
	}
	private int idFranja;
	private int idPista;
	private String nomPista;
	private String esport;
	
	public int getIdFranja() {
		return idFranja;
	}
	public void setIdFranja(int idFranja) {
		this.idFranja = idFranja;
	}
	public int getIdPista() {
		return idPista;
	}
	public void setIdPista(int idPista) {
		this.idPista = idPista;
	}
	
	public InfoFranja toInfoFranja() throws DadaIncorrecta{
		return this;
	}
	
	public String getTitol(){
		return "Franja";
	}
	
	public String getTipus(){
		return "Franja";
	}
	public String getNomPista() {
		return nomPista;
	}
	public void setNomPista(String nomPista) {
		this.nomPista = nomPista;
	}
	public String getEsport() {
		return esport;
	}
	public void setEsport(String esport) {
		this.esport = esport;
	}

}
