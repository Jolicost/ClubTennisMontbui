package Domini.CasosUs.Gestors.Franges;

import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Gestor;
import Domini.Model.Pista;
import Factories.FactoriaControladors;

public class GestorOcupacionsPista extends GestorOcupacions {

	protected int id;
	public GestorOcupacionsPista(int idPista){
		this.id = idPista;
	}
	protected Pista getPista() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlPista().get(id);
	}
	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		getPista().getFrangesOcupades().forEach(o -> ret.add(o.toInfo()));
		return ret;
	}
	
	public Gestor getIndividualInserter() throws Exception {
		return new GestorOcupacioPistaInsert(id);
	}
}
