package Domini.CasosUs.Gestors.Pistes;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.GestorInvalid;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Factories.FactoriaControladors;

public class GestorPistes extends GestorColectiu{

	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		FactoriaControladors.getInstance().getCtrlPista().getAll().forEach(p -> ret.add(p.toInfo()));
		return ret;
	}

	@Override
	public void Delete(Serializable id) throws Exception {
		FactoriaControladors.getInstance().getCtrlPista().Delete(Integer.valueOf(id.toString()));
	}

	@Override
	public Gestor getIndividualUpdater(Serializable id) throws Exception {
		return new GestorPistaUpdate(Integer.valueOf(id.toString()));
	}

	@Override
	public Gestor getIndividualInserter() throws Exception {
		return new GestorPistaInsert();
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getPista();
	}
	




}
