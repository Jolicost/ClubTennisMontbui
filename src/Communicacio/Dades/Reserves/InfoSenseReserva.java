package Communicacio.Dades.Reserves;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoSenseReserva extends InfoReservaSoci {

	public InfoSenseReserva(){
		
	}
	
	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "SR"; 
	}
	
	public String getTipus(){
		return FactoriaTipusReserva.getInstance().getSenseReserva().getNom();
	}
}
