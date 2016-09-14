package Communicacio.Dades.Reserves;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoReservaRanking extends InfoReservaSoci {

	public InfoReservaRanking(){
		
	}
	
	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "Ranking"; 
	}
	
	public String getTipus(){
		return FactoriaTipusReserva.getInstance().getRanking().getNom();
	}
}
