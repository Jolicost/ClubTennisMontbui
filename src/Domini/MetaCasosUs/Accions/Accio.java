package Domini.MetaCasosUs.Accions;

import Communicacio.Dades.Accions.InfoAccio;

public abstract class Accio {
	public Accio(String nom,int rang) {
		super();
		this.nom = nom;
		this.Rang = rang;
	}

	private String nom;
	private int Rang;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public InfoAccio toInfo(){
		InfoAccio ret = crearInfo();
		ret.setTitol(nom);
		return ret;
	}
	
	protected abstract InfoAccio crearInfo();

	public int getRang() {
		return Rang;
	}

	public void setRang(int rang) {
		Rang = rang;
	}
	
}
