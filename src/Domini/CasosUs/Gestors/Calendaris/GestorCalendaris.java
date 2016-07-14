package Domini.CasosUs.Gestors.Calendaris;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.Model.Calendari;
import Factories.FactoriaControladors;

public class GestorCalendaris extends GestorColectiu{



	@Override
	public Gestor getIndividualUpdater(Serializable id) throws Exception {
		return new GestorCalendariUpdate(Integer.valueOf(id.toString()));
	}

	@Override
	public Gestor getIndividualInserter() throws Exception {
		return new GestorCalendariInsert();
	}

	protected Calendari getCalendari(Serializable id) throws Exception{
		return FactoriaControladors.getInstance().getCtrlCalendari().get(Integer.valueOf(id.toString()));
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getCalendari();
	}

	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		FactoriaControladors.getInstance().getCtrlCalendari().getAll().forEach(c -> ret.add(c.toInfo()));
		return ret;
	}

	@Override
	public void Delete(Serializable id) throws Exception {
		FactoriaControladors.getInstance().getCtrlCalendari().Delete(Integer.valueOf(id.toString()));
	}
	
	




}
