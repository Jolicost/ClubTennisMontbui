package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.Formularis.Inputs.BotoLink;

public class BotoDesassignarSoci extends BotoLink {

	public BotoDesassignarSoci() {
		super("Dessasignar Soci","desassignar","desassignar");
		super.AddParameter("entitat", "soci");
	}

}
