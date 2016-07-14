package Communicacio.Dades.Accions;

public class InfoAccioReservar extends InfoAccioIndividual {

	public InfoAccioReservar(String titol,String esport){
		super();
		super.setTitol(titol);
		super.setDispacher("reservar?esport=" + esport);
	}
}
