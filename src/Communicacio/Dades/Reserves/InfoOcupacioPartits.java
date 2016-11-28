package Communicacio.Dades.Reserves;

import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;

public class InfoOcupacioPartits extends InfoOcupacio {

	@Override
	public String getTitol() {
		String ret = super.getTitol();
		return ret + ", " + "Partits"; 
	}

	@Override
	public String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getPartits();
	}

}
