package Domini.CasosUs.Controladors.Reserva.Tipus;

import Communicacio.Dades.Reserves.InfoReservaRanking;
import Communicacio.Dades.Reserves.Tipus.InfoTipusRanking;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioRanking;

public class ComprovarRanking extends TrComprovarTipus {

	@Override
	protected IRestriccio getRestriccioQuota() {
		return new RestriccioRanking(super.s,p);
	}

	@Override
	protected InfoTipusReserva crearResultat() {
		return new InfoTipusRanking();
	}

}
