package Communicacio.Dades.Reserves.Tipus;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoTipusNomesSocis extends InfoTipusLimitada {
	
	
	public String getPanelFile(){
		return "PanellNomesSocis.jsp";
	}

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getNomesSocis().getNom();
	}

}
