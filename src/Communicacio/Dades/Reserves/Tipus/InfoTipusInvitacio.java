package Communicacio.Dades.Reserves.Tipus;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoTipusInvitacio extends InfoTipusLimitada {
	
	
	public String getPanelFile(){
		return "PanellInvitacio.jsp";
	}

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getInvitacio().getNom();
	}

}
