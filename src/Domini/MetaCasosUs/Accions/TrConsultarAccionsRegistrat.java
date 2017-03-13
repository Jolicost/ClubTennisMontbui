package Domini.MetaCasosUs.Accions;

import java.util.List;

import Communicacio.Dades.Accions.InfoAccio;

public class TrConsultarAccionsRegistrat extends TrConsultarAccionsMembre {

	@Override
	protected List<InfoAccio> ConsultarAccions() {
		TrConsultarAccions tr = new TrConsultarAccionsInvitat();
		return tr.consultarAccions();
	}

}
