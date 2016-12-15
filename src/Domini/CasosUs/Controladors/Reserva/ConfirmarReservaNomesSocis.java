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
	
	protected Set<Soci> participants;

	@Override
	protected TrReserva crearTransaccio() throws BDExcepcio {
		TrNomesSocis ret = new TrReservaAnticipada(super.getPista(), i, super.obtenirSoci(), DateTime.now(),participants);
		return ret;
	}

	public Set<Soci> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Soci> participants) {
		this.participants = participants;
	}



}
