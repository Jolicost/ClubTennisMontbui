package Presentacio.Components.Gestors.Calendari;

import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.Formularis.Inputs.BotoLink;

public class BotoGestionarObertures extends BotoLink {

	public BotoGestionarObertures() {
		super("Gestionar Obertures","obertures", "subgestor");
		super.AddParameter("entitat", FactoriaEntitats.getInstance().getObertura());
	}

}
