package Domini.Transaccions.InsertarFranja;

import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.NomesSocis;
import Domini.Model.Reserves.ReservaSoci;

public abstract class TrNomesSocis extends TrReservaSoci {
	private Set<Soci> jugadors;
	public TrNomesSocis(Pista p, Interval dur,Soci propietari,DateTime realitzacio,Set<Soci> Jugadors){
		super(p,dur,propietari,realitzacio);
		jugadors = Jugadors;
	}
	
	protected  ReservaSoci ObtenirReservaSoci() throws NoPotReservar{
		NomesSocis r = ObtenirNomesSocis();
		r.setJugadors(jugadors);
		return r;
		
	}
	protected abstract NomesSocis ObtenirNomesSocis() throws NoPotReservar;
}
