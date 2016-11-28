package Communicacio.Dades.Reserves;

import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;

public class InfoAltres extends InfoOcupacio {

	public String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getAltres();
	}
	
	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "Altres"; 
	}
}
