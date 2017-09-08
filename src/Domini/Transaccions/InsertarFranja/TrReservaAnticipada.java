package Domini.Transaccions.InsertarFranja;

import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.Anticipada;
import Domini.Model.Reserves.NomesSocis;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioNomesSocis;

public class TrReservaAnticipada extends TrNomesSocis {
	public TrReservaAnticipada(Pista p, Interval dur,Soci propietari,DateTime realitzacio,Set<Soci> Participants) {
		super(p, dur, propietari,realitzacio,Participants);
	}




	@Override
	protected NomesSocis ObtenirNomesSocis() throws NoPotReservar {
		return new Anticipada();
	}




	@Override
	protected IRestriccio getRestriccioQuota() {
		return new RestriccioNomesSocis(propietari,p);
	}



	
}
