package Domini.CasosUs.Descriptors.Generals;

import Domini.CasosUs.Descriptors.CasUsDada;
import Domini.CasosUs.Resultats.Generals.ResultatReservesSoci;
import Domini.Transaccions.Reserves.TrConsultarReserves;

public class CasUsConsultarReserves extends CasUsDada {

	@Override
	public void ferCasUs() throws Exception {
		int nsoci = super.getActor().getSoci().getNumero();
		TrConsultarReserves tr = new TrConsultarReserves(nsoci);
		tr.Executar();
		super.resultat = new ResultatReservesSoci(tr.getResultat());
	}

	@Override
	public boolean IsRoot() {
		return true;
	}


	
	
}
