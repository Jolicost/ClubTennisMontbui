package Domini.MetaCasosUs.Accions;

import java.util.ArrayList;
import java.util.List;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.Usuari.InfoAccioLogin;
import Communicacio.Dades.Accions.Usuari.InfoAccioRegistre;

public class TrConsultarAccionsInvitat extends TrConsultarAccions {

	@Override
	protected List<InfoAccio> ConsultarAccions() {
		List<InfoAccio> ret = new ArrayList<>();
		InfoAccio alta = new InfoAccio();
		alta.setTitol("Fer-se Soci");
		alta.setDispacher("AltaSoci");
		ret.add(alta);
		return ret;
	}

	@Override
	protected List<InfoAccio> ConsultarAccionsUsuari() {
		List<InfoAccio> ret = new ArrayList<>();
		ret.add(new InfoAccioRegistre());
		ret.add(new InfoAccioLogin());
		return ret;
	}

}
