package Domini.CasosUs.Controladors.Reserva;

import java.util.HashSet;

import org.joda.time.DateTime;

import Dades.Excepcions.BDExcepcio;
import Domini.Transaccions.InsertarFranja.TrReserva;
import Domini.Transaccions.InsertarFranja.TrReservaRanking;

public class ConfirmarReservaRanking extends ConfirmarReserva {

	@Override
	protected TrReserva crearTransaccio() throws BDExcepcio {
		return new TrReservaRanking(p, i, s,DateTime.now(),new HashSet<>());
	}

}
