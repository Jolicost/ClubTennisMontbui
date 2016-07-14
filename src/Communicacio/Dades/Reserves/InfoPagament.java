package Communicacio.Dades.Reserves;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoPagament extends InfoReservaSoci {

	public InfoPagament(){
		
	}
	
	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "Pagament"; 
	}
	
	public String getTipus(){
		return FactoriaTipusReserva.getInstance().getPagament().getNom();
	}
}
