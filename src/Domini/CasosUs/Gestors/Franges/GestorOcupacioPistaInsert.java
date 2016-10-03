package Domini.CasosUs.Gestors.Franges;

import Communicacio.Dades.Info;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Accions.FactoriaAccions;
import Domini.Model.Pista;
import Domini.Model.Reserves.Franja;
import Factories.FactoriaControladors;

public class GestorOcupacioPistaInsert extends GestorOcupacio{

	private int idPista;
	public GestorOcupacioPistaInsert(int idPista) {
		super(FactoriaAccions.getInstance().getInsert());
		this.idPista = idPista;
	}
	
	protected Pista getPista() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlPista().get(idPista);
	}
	
	@Override
	public void Insert(Info i) throws Exception {
		Franja f = super.crearFranja(i);
		Pista p = getPista();
		f.setPista(p);
		p.AfegirFranja(f);
		FactoriaControladors.getInstance().getCtrlFranja().Insert(f);
	}

}
