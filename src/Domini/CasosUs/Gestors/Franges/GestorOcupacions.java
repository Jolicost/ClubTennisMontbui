package Domini.CasosUs.Gestors.Franges;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Accions.FactoriaAccions;
import Domini.Model.Reserves.Franja;
import Factories.FactoriaControladors;

public class GestorOcupacions extends GestorFranges {

	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		FactoriaControladors.getInstance().getCtrlOcupacio().getAll().forEach(o -> ret.add(o.toInfo()));
		return ret;
	}
	
	@Override
	public Gestor getIndividualUpdater(Serializable id) throws Exception {
		int idFranja = Integer.valueOf(id.toString());
		Franja f = FactoriaControladors.getInstance().getCtrlFranja().get(idFranja);
		return f.getTipusFranja().getGestorFranjaUpdate(idFranja);
	}

	@Override
	public Gestor getIndividualInserter() throws Exception {
		return new GestorOcupacio(FactoriaAccions.getInstance().getInsert());
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getOcupacio();
	}

}
