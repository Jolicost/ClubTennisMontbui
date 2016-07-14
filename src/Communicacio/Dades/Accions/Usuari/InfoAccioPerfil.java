package Communicacio.Dades.Accions.Usuari;

import Communicacio.Dades.Accions.InfoAccioIndividual;

public class InfoAccioPerfil extends InfoAccioIndividual{

	public InfoAccioPerfil(){
		super();
		super.setDispacher("Perfil");
		super.setTitol("Perfil");
	}
	
	public String getGlyph(){
		return "user";
	}
}
