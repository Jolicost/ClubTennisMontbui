package Domini.CasosUs.Controladors.Reserva.Tipus;

import Communicacio.Dades.Reserves.Tipus.InfoTipusPagament;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioAnticipada;

public class ComprovarPagament extends TrComprovarTipus {



	public ComprovarPagament() {
		super();
	}

	@Override
	protected IRestriccio getRestriccioQuota()  {
		return new RestriccioAnticipada(s,p);
	}

	@Override
	protected InfoTipusReserva crearResultat() {
		return new InfoTipusPagament();
	}



}
