package Domini.CasosUs.Controladors.Quotes;

import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatEscriptura;
import Domini.Model.Soci;
import Factories.FactoriaControladors;

public class EstatSeleccionarTitular extends EstatAssignarQuota{

	public EstatSeleccionarTitular(int IDSoci) {
		super(IDSoci);
	}
	
	protected Soci getSoci(int n) throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlSoci().get(IDSoci);
	}
	public ResultatEntitat SeleccionarTitular(int IDSoci) throws Exception{
		TrAssignarQuotaMembre tr = new TrAssignarQuotaMembre();
		tr.setIDSoci(this.IDSoci);
		tr.setTitular(IDSoci);
		tr.Executar();		
		
		super.setSeguent(new EstatAssignarFinalitzat(IDSoci));
		
		return new ResultatEscriptura();
	}

}
