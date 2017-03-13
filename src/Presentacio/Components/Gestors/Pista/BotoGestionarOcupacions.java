package Presentacio.Components.Gestors.Pista;

import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.Formularis.Inputs.BotoLink;

public class BotoGestionarOcupacions extends BotoLink {

	public BotoGestionarOcupacions() {
		
		super("Gestionar Ocupacions","ocupacions","subgestor");
		super.AddParameter("entitat", FactoriaEntitats.getInstance().getOcupacio());
	}



}
