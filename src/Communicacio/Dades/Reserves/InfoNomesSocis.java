package Communicacio.Dades.Reserves;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoNomesSocis extends InfoReservaSoci {

	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "Nomes Socis"; 
	}
	
	public String getTipus(){
		return FactoriaTipusReserva.getInstance().getNomesSocis().getNom();
	}
}
