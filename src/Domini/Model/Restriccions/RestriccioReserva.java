package Domini.Model.Restriccions;

import java.util.Set;

import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;

public abstract class RestriccioReserva implements IRestriccio {

	public RestriccioReserva(Soci s) {
		super();
		this.s = s;
	}

	protected Soci s;


}
