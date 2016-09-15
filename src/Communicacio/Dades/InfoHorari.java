package Communicacio.Dades;

import java.util.SortedSet;


public class InfoHorari extends Info implements Comparable<InfoHorari>{
	private SortedSet<InfoLapse> disponibilitats;
	private int IDPista;
	private String nomPista;

	public SortedSet<InfoLapse> getDisponibilitats() {
		return disponibilitats;
	}

	public void setDisponibilitats(SortedSet<InfoLapse> disponibilitats) {
		this.disponibilitats = disponibilitats;
	}

	public InfoHorari(SortedSet<InfoLapse> disponibilitats,int IDPista) {
		super();
		this.disponibilitats = disponibilitats;
		this.IDPista = IDPista;
	}
	public InfoHorari(){}

	public int getIDPista() {
		return IDPista;
	}

	public void setIDPista(int iDPista) {
		IDPista = iDPista;
	}

	@Override
	public String toString() {
		return IDPista + ": " + disponibilitats.toString();
	}

	public String getNomPista() {
		return nomPista;
	}

	public void setNomPista(String nomPista) {
		this.nomPista = nomPista;
	}

	@Override
	public int compareTo(InfoHorari o) {
		return this.nomPista.compareTo(o.nomPista);
	}
	

	

	
}
