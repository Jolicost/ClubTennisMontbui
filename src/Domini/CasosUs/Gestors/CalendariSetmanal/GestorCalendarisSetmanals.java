package Domini.CasosUs.Gestors.CalendariSetmanal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Domini.CasosUs.Gestors.GestorColectiu;
import Factories.FactoriaControladors;

public abstract class GestorCalendarisSetmanals extends GestorColectiu {

	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		FactoriaControladors.getInstance().getCtrlCalendariSetmanal().getAll().forEach(
				c->	
				ret.add(c.toInfo())
				);
		return ret;
	}

	@Override
	public void Delete(Serializable id) throws Exception {
		FactoriaControladors.getInstance().getCtrlCalendariSetmanal().Delete(Integer.valueOf(id.toString()));
	}

}
