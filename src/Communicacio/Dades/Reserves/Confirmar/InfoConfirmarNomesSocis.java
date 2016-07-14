package Communicacio.Dades.Reserves.Confirmar;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoConfirmarNomesSocis extends InfoConfirmarLimitada {

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getNomesSocis().getNom();
	}

	public String getView(){
		return "panellNomesSocis.jsp";
	}
}
