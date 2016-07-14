package Communicacio.Dades.Reserves.Confirmar;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoConfirmarInvitacio extends InfoConfirmarLimitada{

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getInvitacio().getNom();
	}
	
	public String getView(){
		return "panellInvitacio.jsp";
	}

}
