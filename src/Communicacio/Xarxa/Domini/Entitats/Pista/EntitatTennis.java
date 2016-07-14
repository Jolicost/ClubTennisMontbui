package Communicacio.Xarxa.Domini.Entitats.Pista;

import Domini.Model.Pista;
import Domini.Model.Tennis;

public class EntitatTennis extends EntitatTipusPista {

	@Override
	public String getNomPista() {
		return "tennis";
	}

	@Override
	public Pista crearPista() {
		return new Tennis();
	}

}
