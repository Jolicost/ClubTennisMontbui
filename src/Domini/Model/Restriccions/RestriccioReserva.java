package Domini.Model.Restriccions;

import java.util.Set;

import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;

public abstract class RestriccioReserva implements IRestriccio {

	public RestriccioReserva(Soci s,Pista p) {
		super();
		this.s = s;
		this.p = p;
	}

	protected Soci s;
	protected Pista p;


}
