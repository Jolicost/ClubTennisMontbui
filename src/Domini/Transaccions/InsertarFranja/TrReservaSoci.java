package Domini.Transaccions.InsertarFranja;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.InsuficientQuota;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.Reserva;
import Domini.Model.Reserves.ReservaSoci;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioPista;

public abstract class TrReservaSoci extends TrReserva {
	
	public TrReservaSoci(Pista p, Interval dur,Soci propietari,DateTime realitzacio) {
		super(p, dur,realitzacio);
		this.propietari = propietari;
	}

	protected Soci propietari;
	
	protected  Reserva ObtenirReserva() throws NoPotReservar, BDExcepcio{
		ReservaSoci r = ObtenirReservaSoci();
		r.setPropietari(propietari);
		ComprovarQuota();
		propietari.afegirReserva(r);
		return r;
	}
	
	protected abstract ReservaSoci ObtenirReservaSoci() throws NoPotReservar;
	protected abstract IRestriccio getRestriccioQuota();
	
	private void ComprovarQuota() throws BDExcepcio, NoPotReservar{
		RestriccioPista rp = new RestriccioPista(p,propietari);
		rp.Test(Duracio);
		IRestriccio quota = getRestriccioQuota();
		quota.Test(Duracio);
	}
	

	
	
	
	
}
