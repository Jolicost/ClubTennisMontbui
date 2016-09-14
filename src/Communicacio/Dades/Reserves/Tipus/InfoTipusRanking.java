package Communicacio.Dades.Reserves.Tipus;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoTipusRanking extends InfoTipusLimitada{

	
	public String getPanelFile(){
		return "PanellRanking.jsp";
	}
	
	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getRanking().getNom();
	}

}
