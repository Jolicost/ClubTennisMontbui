package Communicacio.Dades.Reserves.Confirmar;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoConfirmarRanking extends InfoConfirmarLimitada {

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getRanking().getNom();
	}
	
	public String getView(){
		return "panellRanking.jsp";
	}
}
