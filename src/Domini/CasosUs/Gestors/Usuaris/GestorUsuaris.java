package Domini.CasosUs.Gestors.Usuaris;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.CasosUs.Gestors.Accions.FactoriaAccions;
import Factories.FactoriaControladors;

public class GestorUsuaris extends GestorColectiu{

	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		FactoriaControladors.getInstance().getCtrlUsuari().getAll().forEach(u -> ret.add(u.toInfo()));
		return ret;
	}

	@Override
	public void Delete(Serializable id) throws Exception {
		FactoriaControladors.getInstance().getCtrlUsuari().Delete(id.toString());
	}

	@Override
	public Gestor getIndividualUpdater(Serializable id) throws Exception {
		return new GestorUsuariAdmin(id.toString(),FactoriaAccions.getInstance().getUpdate());
	}

	@Override
	public Gestor getIndividualInserter() throws Exception {
		return new GestorUsuariAdmin(FactoriaAccions.getInstance().getInsert());
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getUsuari();
	}



}
