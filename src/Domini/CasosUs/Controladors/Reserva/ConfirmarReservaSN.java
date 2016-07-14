package Domini.CasosUs.Controladors.Reserva;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;
import Domini.Transaccions.InsertarFranja.TrReserva;
import Domini.Transaccions.InsertarFranja.TrSenseReserva;


public class ConfirmarReservaSN extends ConfirmarReserva {

	public ConfirmarReservaSN() {
		super();
	}

	@Override
	protected TrReserva crearTransaccio() throws BDExcepcio {
		Set<Soci> socis = new HashSet<>();
		TrSenseReserva ret = new TrSenseReserva(super.getPista(), i, super.obtenirSoci(), DateTime.now(), socis);
		return ret;
	}

}
