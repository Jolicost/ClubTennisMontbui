package Communicacio.Dades.Reserves.Confirmar;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoConfirmarSenseReserva extends InfoConfirmarReserva {

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getSenseReserva().getNom();
	}

	public String getView(){
		return "panellSenseReserva.jsp";
	}
}
