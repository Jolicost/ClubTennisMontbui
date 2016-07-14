package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.Formularis.Inputs.Boto;
import Presentacio.Components.Formularis.Inputs.BotoLink;
import Presentacio.TagBuilder.CenteredDesktopColumnTag;
import Presentacio.TagBuilder.TagFactory;

public class BotoAssignarSoci extends BotoLink {

	public BotoAssignarSoci() {
		
		super("Assignar Soci","assignar","assignar");
		super.AddParameter("entitat", "soci");
	}



}
