package Domini.Model.Restriccions;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;

public class RestriccioSenseReserva extends RestriccioReserva {

	public RestriccioSenseReserva(Soci s) {
		super(s);
	}

	@Override
	public Set<Interval> Filtrar(Set<Interval> in) {
		Set<Interval> ret = new HashSet<>();
		
		Predicate<Interval> p = crearFiltre();
		for (Interval i: in) if (p.test(i)) ret.add(i);

		return ret;
	}

	@Override
	public int Test(Interval in) throws NoPotReservar {
		if (!crearFiltre().test(in)){
			throw new NoPotReservar();
		}
		return 1;
	}
	
	protected Predicate<Interval> crearFiltre(){
		Predicate<Interval> ret = i -> i.getStart().isBefore(DateTime.now().plusMinutes(15));
		return ret.or(crearFiltreAbans());
	}
	
	protected Predicate<Interval> crearFiltreAbans(){
		Predicate<Interval> ret = i -> (i.containsNow() && DateTime.now().plusMinutes(10).isBefore(i.getEnd()));
		return ret;
	}

}
