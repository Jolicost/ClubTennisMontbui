package Communicacio.Dades.Accions.Usuari;

import Communicacio.Dades.Accions.InfoAccioIndividual;

public class InfoAccioRegistre extends InfoAccioIndividual{

	public InfoAccioRegistre(){
		super();
		super.setDispacher("registre");
		super.setTitol("Registre");
	}
	
	public String getGlyph(){
		return "user";
	}
}
