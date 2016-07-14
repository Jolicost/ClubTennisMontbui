package Domini.Transaccions.InsertarFranja;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Reserves.Ocupacio;
import Domini.Model.Reserves.Reserva;

public abstract class TrReserva extends TrOcuparPista {

	private DateTime Data;
	public TrReserva(Pista p, Interval dur, DateTime realitzacio) {
		super(p, dur);
		Data = realitzacio;
	}
	
	@Override
	protected Ocupacio ObtenirOcupacio() throws NoPotReservar, BDExcepcio {
		Reserva r = ObtenirReserva();
		r.setDataRealitzada(Data);
		return r;
	}
	
	protected abstract Reserva ObtenirReserva() throws NoPotReservar, BDExcepcio;

}
