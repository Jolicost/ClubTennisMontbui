package Communicacio.Dades.Accions.Usuari;

import Communicacio.Dades.Accions.InfoAccioIndividual;

public class InfoAccioLogin extends InfoAccioIndividual{

	public InfoAccioLogin(){
		super();
		super.setDispacher("login");
		super.setTitol("Login");
	}
	
	public String getGlyph(){
		return "log-in";
	}
}
