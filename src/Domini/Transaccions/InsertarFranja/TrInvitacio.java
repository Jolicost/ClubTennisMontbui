package Domini.Transaccions.InsertarFranja;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Domini.Excepcions.InsuficientQuota;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.Invitacio;
import Domini.Model.Reserves.ReservaSoci;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioAnticipada;
import Domini.Model.Restriccions.RestriccioInvitacio;

public class TrInvitacio extends TrReservaSoci {

	public TrInvitacio(Pista p, Interval dur,Soci propietari,DateTime realitzacio) {
		super(p, dur, propietari, realitzacio);
	}

	@Override
	protected ReservaSoci ObtenirReservaSoci() throws NoPotReservar {
		RestriccioInvitacio ri = new RestriccioInvitacio(propietari,super.p);
		ri.Test(Duracio);
		return new Invitacio();
	}
	@Override
	protected IRestriccio getRestriccioQuota() {
		return new RestriccioInvitacio(propietari,super.p);
	}

}
