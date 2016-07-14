package Domini.CasosUs.Controladors.Reserva;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;
import Domini.Transaccions.InsertarFranja.TrNomesSocis;
import Domini.Transaccions.InsertarFranja.TrReserva;
import Domini.Transaccions.InsertarFranja.TrReservaAnticipada;

public class ConfirmarReservaNomesSocis extends ConfirmarReserva{

	public ConfirmarReservaNomesSocis() {
		super();
	}

	@Override
	protected TrReserva crearTransaccio() throws BDExcepcio {
		Set<Soci> socis = new HashSet<>();
		TrNomesSocis ret = new TrReservaAnticipada(super.getPista(), i, super.obtenirSoci(), DateTime.now(), socis);
		return ret;
	}



}
