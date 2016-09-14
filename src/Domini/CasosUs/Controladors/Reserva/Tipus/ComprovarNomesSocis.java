package Domini.CasosUs.Controladors.Reserva.Tipus;

import Communicacio.Dades.Reserves.Tipus.InfoTipusNomesSocis;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioAnticipada;

public class ComprovarNomesSocis extends TrComprovarTipus {



	public ComprovarNomesSocis() {
		super();
	}


	@Override
	protected IRestriccio getRestriccioQuota() {
		return new RestriccioAnticipada(s,p);
	}

	@Override
	protected InfoTipusReserva crearResultat() {
		return new InfoTipusNomesSocis();
	}

}
