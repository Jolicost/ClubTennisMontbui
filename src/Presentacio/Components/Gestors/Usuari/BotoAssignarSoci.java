package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.Formularis.Inputs.BotoLink;

public class BotoAssignarSoci extends BotoLink {

	public BotoAssignarSoci() {
		
		super("Assignar Soci","assignar","assignar");
		super.AddParameter("entitat", "soci");
	}



}
