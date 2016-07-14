package Communicacio.Dades.Accions;

public class InfoAccioGestor extends InfoAccioIndividual {

	
	public InfoAccioGestor(String titol,String entitat){
		super();
		super.setTitol(titol);
		super.setDispacher("gestor?entitat=" + entitat);
	}
}
