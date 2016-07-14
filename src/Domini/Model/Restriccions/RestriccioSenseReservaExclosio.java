package Domini.Model.Restriccions;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;

public class RestriccioSenseReservaExclosio extends RestriccioSenseReserva{

	public RestriccioSenseReservaExclosio(Soci s) {
		super(s);
	}
	
	@Override
	public Set<Interval> Filtrar(Set<Interval> in) {
		Predicate<ReservaSoci> sr = rs -> rs.EsSenseReserva() && rs.EstaActiva();
		if (s.ReservaExistix(sr)) {
			in.removeAll(super.Filtrar(in));
		}
		
		in.removeIf(crearFiltreAbansExclosio());
		
		return in;
	}
	
	protected Predicate<Interval> crearFiltreAbansExclosio(){
		Predicate<Interval> ret = i -> (i.containsNow() && DateTime.now().plusMinutes(10).isAfter(i.getEnd()));
		return ret;
	}

	@Override
	public int Test(Interval in) throws NoPotReservar {
		Predicate<ReservaSoci> sr = rs -> rs.EsSenseReserva() && rs.EstaActiva();
		if (s.ReservaExistix(sr)){
			if (crearFiltre().test(in)){
				throw new NoPotReservar();
			}
		}
		return 1;
	}

}
