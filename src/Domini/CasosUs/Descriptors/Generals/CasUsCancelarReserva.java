package Domini.CasosUs.Descriptors.Generals;

import Communicacio.Dades.Reserves.InfoFranja;
import Domini.CasosUs.Actors.Registrat;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Descriptors.CasUsDada;
import Domini.CasosUs.Resultats.ResultatIndividual;
import Domini.CasosUs.Resultats.Generals.ResultatReservesSoci;
import Domini.Model.Usuari;
import Domini.Transaccions.Reserves.TrCancelarReserva;
import Factories.FactoriaControladors;

public class CasUsCancelarReserva extends CasUsDada {

	@Override
	public void ferCasUs() throws Exception {
		int idSoci = super.getActor().getSoci().getNumero();
		InfoFranja f = super.getDada().toInfoFranja();
		int idFranja = f.getIdFranja();
		TrCancelarReserva tr = new TrCancelarReserva(idSoci,idFranja);
		tr.Executar();
		
		CasUsConsultarReserves cur = new CasUsConsultarReserves();
		cur.setActor(this.getActor());
		cur.ferCasUs();
		this.resultat = cur.getResultat();
		
	}

	@Override
	public boolean IsRoot() {
		return true;
	}

}
