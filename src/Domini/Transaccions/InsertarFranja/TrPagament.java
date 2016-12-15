package Domini.Transaccions.InsertarFranja;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.Pagament;
import Domini.Model.Reserves.ReservaSoci;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioAnticipada;
import Domini.Model.Restriccions.RestriccioPagament;
import Domini.Model.Restriccions.RestriccioReservaLimitada;

public class TrPagament extends TrReservaSoci {

	public TrPagament(Pista p, Interval dur, Soci propietari,DateTime realitzacio) {
		super(p, dur, propietari, realitzacio);
	}

	@Override
	protected ReservaSoci ObtenirReservaSoci() throws NoPotReservar {
		return new Pagament();
	}

	@Override
	protected IRestriccio getRestriccioQuota() {
		return new RestriccioPagament(propietari,p);
	}
	

}
