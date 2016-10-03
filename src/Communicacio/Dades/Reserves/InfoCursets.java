package Communicacio.Dades.Reserves;

import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;

public class InfoCursets extends InfoOcupacio{

	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + "Cursets"; 
	}
	
	public String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getCursets();
	}
}
