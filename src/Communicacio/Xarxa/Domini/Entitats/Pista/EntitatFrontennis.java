package Communicacio.Xarxa.Domini.Entitats.Pista;

import Domini.Model.Frontennis;
import Domini.Model.Pista;

public class EntitatFrontennis extends EntitatTipusPista {

	@Override
	public String getNomPista() {
		return "frontennis";
	}

	@Override
	public Pista crearPista() {
		return new Frontennis();
	}

}
