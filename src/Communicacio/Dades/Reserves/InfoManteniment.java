package Communicacio.Dades.Reserves;

import Communicacio.Xarxa.Domini.Entitats.Ocupacio.FactoriaTipusOcupacio;

public class InfoManteniment extends InfoOcupacio {

	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "Manteniment"; 
	}
	
	public String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getManteniment();
	}
	

}
