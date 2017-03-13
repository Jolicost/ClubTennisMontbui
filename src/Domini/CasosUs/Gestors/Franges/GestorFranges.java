package Domini.CasosUs.Gestors.Franges;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Domini.CasosUs.Gestors.GestorColectiu;
import Factories.FactoriaControladors;

public abstract class GestorFranges extends GestorColectiu{

	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		FactoriaControladors.getInstance().getCtrlFranja().getAll().forEach(f -> ret.add(f.toInfo()));
		return ret;
	}

	@Override
	public void Delete(Serializable id) throws Exception {
		FactoriaControladors.getInstance().getCtrlFranja().delete(Integer.valueOf(id.toString()));
	}



}
