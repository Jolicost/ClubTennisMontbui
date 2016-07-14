package Communicacio.Dades.Reserves.Tipus;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoTipusPagament extends InfoTipusLimitada {
	
	
	public String getPanelFile(){
		return "PanellPagament.jsp";
	}

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getPagament().getNom();
	}

}
