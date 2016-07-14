package Domini.CasosUs.Controladors.Reserva.Tipus;

import org.joda.time.Interval;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarNomesSocis;
import Communicacio.Dades.Reserves.Tipus.InfoTipusNomesSocis;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioAnticipada;

public class ComprovarNomesSocis extends TrComprovarTipus {



	public ComprovarNomesSocis() {
		super();
	}


	@Override
	protected IRestriccio getRestriccioQuota() {
		return new RestriccioAnticipada(s);
	}

	@Override
	protected InfoTipusReserva crearResultat() {
		return new InfoTipusNomesSocis();
	}

}
