package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.Tipus.InfoTipusRanking;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReservaRanking;
import Domini.CasosUs.Controladors.Reserva.Confirmar.ConfirmacioRanking;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.ComprovarRanking;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;

public class ReservaTipusRanking extends TipusReserva{

	@Override
	public String getNom() {
		return "Ranking";
	}

	@Override
	public ConfirmarReserva getConfirmar() {
		return new ConfirmarReservaRanking();
	}

	@Override
	public String getDescripcio() {
		return "Aquest tipus de reserva és exclusiu dels partits del rànking";
	}

	@Override
	protected InfoTipusReserva createInfo() {
		return new InfoTipusRanking();
	}

	@Override
	public TrComprovarTipus crearTransaccioComprovar() {
		return new ComprovarRanking();
	}

	@Override
	public TrObtenirConfirmacio crearTransaccioObtenirConfirmacio() {
		return new ConfirmacioRanking();
	}

}
