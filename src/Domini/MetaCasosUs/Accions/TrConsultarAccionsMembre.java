package Domini.MetaCasosUs.Accions;

import java.util.ArrayList;
import java.util.List;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.Usuari.InfoAccioLogout;
import Communicacio.Dades.Accions.Usuari.InfoAccioPerfil;

public abstract class TrConsultarAccionsMembre extends TrConsultarAccions {

	@Override
	protected List<InfoAccio> ConsultarAccionsUsuari() {
		List<InfoAccio> ret = new ArrayList<>();
		ret.add(new InfoAccioPerfil());
		ret.add(new InfoAccioLogout());
		return ret;
	}
}
