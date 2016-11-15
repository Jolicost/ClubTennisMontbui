package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.Tipus.InfoTipusNomesSocis;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReservaNomesSocis;
import Domini.CasosUs.Controladors.Reserva.EstatFerReserva;
import Domini.CasosUs.Controladors.Reserva.Confirmar.ConfirmacioNomesSocis;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.ComprovarNomesSocis;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;

public class ReservaNomesSocis extends TipusReserva{

	@Override
	public String getNom() {
		return "Nomes socis";
	}

	@Override
	public ConfirmarReserva getConfirmar() {
		return new ConfirmarReservaNomesSocis();
	}

	@Override
	public String getDescripcio() {
		return "aquest tipus de reserva es sols per a socis";
	}

	@Override
	protected InfoTipusReserva createInfo() {
		return new InfoTipusNomesSocis();
	}

	@Override
	public TrComprovarTipus crearTransaccioComprovar() {
		return new ComprovarNomesSocis();
	}

	@Override
	public TrObtenirConfirmacio crearTransaccioObtenirConfirmacio() {
		return new ConfirmacioNomesSocis();
	}

}
