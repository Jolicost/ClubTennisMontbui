package Communicacio.Dades.Reserves;

import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;

public class InfoManteniment extends InfoOcupacio {

	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "Manteniment"; 
	}
	
	public String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getManteniment();
	}
	

}
