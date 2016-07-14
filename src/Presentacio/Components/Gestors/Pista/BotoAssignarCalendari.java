package Presentacio.Components.Gestors.Pista;

import Presentacio.Components.Formularis.Inputs.BotoLink;
import Presentacio.TagBuilder.CenteredDesktopColumnTag;
import Presentacio.TagBuilder.DefaultTag;
import Presentacio.TagBuilder.TagFactory;

public class BotoAssignarCalendari extends BotoLink {

	public BotoAssignarCalendari() {
		
		super("Assignar Calendari","assignar_calendari","assignar");
		super.AddParameter("entitat", "calendari");
	}



}
