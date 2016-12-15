package Domini.Model.Reserves.Tipus;

import org.joda.time.Interval;

import Communicacio.Dades.Reserves.Tipus.InfoTipusPagament;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReservaPagament;
import Domini.CasosUs.Controladors.Reserva.Confirmar.ConfirmacioPagament;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.ComprovarPagament;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;

public class ReservaPagament extends TipusReserva {

	@Override
	public String getNom() {
		return "Pagament";
	}

	@Override
	public ConfirmarReserva getConfirmar() {
		return new ConfirmarReservaPagament();
	}

	@Override
	public String getDescripcio() {
		return "aquest tipus de reserva és de pagament";
	}

	@Override
	protected InfoTipusReserva createInfo() {
		return new InfoTipusPagament();
	}

	@Override
	public TrComprovarTipus crearTransaccioComprovar() {
		return new ComprovarPagament();
	}

	@Override
	public TrObtenirConfirmacio crearTransaccioObtenirConfirmacio() {
		return new ConfirmacioPagament();
	}
	
	public Interval getIntervalPertanyent(Interval i) {
		return new Interval(
				i.getStart().dayOfWeek().withMinimumValue().millisOfDay().withMinimumValue(),
				i.getStart().dayOfWeek().withMaximumValue().millisOfDay().withMaximumValue());
	}

}
