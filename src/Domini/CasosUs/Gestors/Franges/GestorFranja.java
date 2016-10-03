package Domini.CasosUs.Gestors.Franges;

import Communicacio.Dades.Info;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.GestorIndividualAccio;
import Domini.CasosUs.Gestors.Accions.Accio;
import Domini.Model.Reserves.Franja;
import Factories.FactoriaControladors;

public abstract class GestorFranja extends GestorIndividualAccio {

	protected int idFranja;
	
	public GestorFranja(Accio accio) {
		super(accio);
	}
	
	public GestorFranja(Accio accio,int idFranja){
		super(accio);
		this.idFranja = idFranja;
	}
	protected void InsertFranja(Franja f) throws BDExcepcio{
		FactoriaControladors.getInstance().getCtrlFranja().Insert(f);
	}
	
	public void Insert(Info i) throws Exception {
		InsertFranja(crearFranja(i));
	}
	
	@Override
	public void Update(Info i) throws Exception {
		Franja f = editarFranja(i);
		FactoriaControladors.getInstance().getCtrlFranja().Update(f);
	}

	
	protected Franja get(int id) throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlFranja().get(id);
	}
	
	@Override
	public Info Get() throws Exception {
		return get(idFranja).toInfo();
	}

	
	protected abstract Franja crearFranja(Info i) throws Exception;
	protected abstract Franja editarFranja(Info i) throws Exception;
}
