package Communicacio.Dades.Accions.Usuari;

import Communicacio.Dades.Accions.InfoAccioIndividual;

public class InfoAccioLogout extends InfoAccioIndividual {

	public InfoAccioLogout(){
		super();
		super.setDispacher("logout");
		super.setTitol("Logout");
	}
	
	public String getGlyph(){
		return "log-out";
	}
}
