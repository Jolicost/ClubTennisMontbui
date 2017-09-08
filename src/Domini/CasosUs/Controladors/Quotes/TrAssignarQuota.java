package Domini.CasosUs.Controladors.Quotes;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;
import Domini.Model.Quotes.Quota;
import Factories.FactoriaControladors;

public abstract class TrAssignarQuota {
	protected int IDSoci;

	protected Soci s;
	public TrAssignarQuota(){
		
	}

	public int getIDSoci() {
		return IDSoci;
	}

	public void setIDSoci(int iDSoci) {
		IDSoci = iDSoci;
	}
	
	protected Soci getSoci(int ID) throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlSoci().get(ID);
	}
	
	public void Executar() throws Exception{
		s = getSoci(IDSoci);
		FactoriaControladors.getInstance().getCtrlQuota().Delete(s.getQ().getId());
		
		s.canviarQuota(this.crearQuota());
		FactoriaControladors.getInstance().getCtrlQuota().Insert(s.getQ());
	}
	
	protected abstract Quota crearQuota() throws Exception;
	
}
