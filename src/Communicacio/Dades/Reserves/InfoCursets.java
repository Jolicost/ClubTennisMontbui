package Communicacio.Dades.Reserves;

import Communicacio.Xarxa.Domini.Entitats.Ocupacio.FactoriaTipusOcupacio;

public class InfoCursets extends InfoOcupacio{

	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "Cursets"; 
	}
	
	public String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getCursets();
	}
}
