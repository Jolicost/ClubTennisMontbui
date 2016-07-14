package Communicacio.Dades.Reserves.Confirmar;

import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class InfoConfirmarPagament extends InfoConfirmarLimitada {

	public InfoConfirmarPagament() {
		super();
	}

	private double preu;

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getPagament().getNom();
	}
	
	public String getView(){
		return "panellPagament.jsp";
	}
	
}
