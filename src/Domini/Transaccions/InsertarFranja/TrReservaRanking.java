package Domini.Transaccions.InsertarFranja;

import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.NomesSocis;
import Domini.Model.Reserves.ReservaRanking;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioRanking;

public class TrReservaRanking extends TrNomesSocis {

	public TrReservaRanking(Pista p, Interval dur, Soci propietari, DateTime realitzacio, Set<Soci> Jugadors) {
		super(p, dur, propietari, realitzacio, Jugadors);
	}

	@Override
	protected NomesSocis ObtenirNomesSocis() throws NoPotReservar {
		return new ReservaRanking();
	}

	@Override
	protected IRestriccio getRestriccioQuota() {
		return new RestriccioRanking(this.propietari,p);
	}

}
