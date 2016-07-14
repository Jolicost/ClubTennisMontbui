package Domini.Transaccions.InsertarFranja;

import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Domini.Excepcions.MassesReserves;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.NomesSocis;
import Domini.Model.Reserves.SR;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioAnticipada;
import Domini.Model.Restriccions.RestriccioSenseReserva;

public class TrSenseReserva extends TrNomesSocis {

	public TrSenseReserva(Pista p, Interval dur,Soci propietari,DateTime realitzacio, Set<Soci> jugadors) {
		super(p, dur, propietari, realitzacio, jugadors);
	}

	@Override
	protected NomesSocis ObtenirNomesSocis() throws NoPotReservar {
		return new SR();
	}

	@Override
	protected IRestriccio getRestriccioQuota() {
		return new RestriccioSenseReserva(propietari);
	}

}
