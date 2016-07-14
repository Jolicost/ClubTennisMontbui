package Communicacio.Dades.Reserves;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoInvitacio extends InfoReservaSoci{

	public InfoInvitacio(){
		
	}
	
	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "Invitacio"; 
	}
	
	public String getTipus(){
		return FactoriaTipusReserva.getInstance().getInvitacio().getNom();
	}
}
