package Domini.CasosUs.Gestors.CalendariSetmanal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Gestors.Gestor;
import Factories.FactoriaControladors;

public class GestorCalendariOcupacions extends GestorCalendarisSetmanals {

	@Override
	public Gestor getIndividualUpdater(Serializable id) throws Exception {
		return new GestorCalendariOcupacionsUpdate(Integer.valueOf(id.toString()));
	}

	@Override
	public Gestor getIndividualInserter() throws Exception {
		return new GestorCalendariOcupacionsInsert();
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getCalendariSetmanal();
	}
	
	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		FactoriaControladors.getInstance().getCtrlCalendariOcupacions().getAll().forEach(
				c->	
				ret.add(c.toInfo())
				);
		return ret;
	}

}
