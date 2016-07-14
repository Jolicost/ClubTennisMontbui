package Domini.Model.Restriccions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.joda.time.Interval;

import Domini.Excepcions.InsuficientQuota;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;

public abstract class RestriccioReservaLimitada extends RestriccioReserva {

	public RestriccioReservaLimitada(Soci s) {
		super(s);
	}

	@Override
	public Set<Interval> Filtrar(Set<Interval> in) {
		Set<Interval> ret = new HashSet<>();
		for (Set<Interval> res : Separar(in)){
			Predicate<ReservaSoci> p = this.createPredicate();
			Interval example = res.iterator().next();
			Interval per = this.getIntervalPertanyent(example);
			
			Predicate<ReservaSoci> espai = r -> r.Intersecciona(per);
			espai = p.and(espai);
			
			Set<ReservaSoci> mateixEspai = s.getReservesCondicio(espai);
			if (mateixEspai.size() < this.getLimit()){
				ret.addAll(res);
			}
		}
		return ret;
	}

	@Override
	public int Test(Interval in) throws NoPotReservar {
		Predicate<ReservaSoci> p = this.createPredicate();
		Interval per = this.getIntervalPertanyent(in);
		
		Predicate<ReservaSoci> espai = r -> r.Intersecciona(per);
		espai = p.and(espai);
		
		Set<ReservaSoci> mateixEspai = s.getReservesCondicio(espai);
		int r =  this.getLimit() - mateixEspai.size();
		if (r <= 0) throw new InsuficientQuota();
		return r;
	}
	
	private Set<Set<Interval>> Separar(Set<Interval> in){
		Set<Set<Interval>> ret = new HashSet<>();
		Map<Integer,Set<Interval>> setmanes = new HashMap<>();
		for (Interval i : in){
			int setmana = getTimeKey(i);
			if (setmanes.containsKey(setmana)){
				setmanes.get(setmana).add(i);
			}
			else{
				Set<Interval> nou = new HashSet<>();
				nou.add(i);
				setmanes.put(setmana,nou);
			}
		}
		ret.addAll(setmanes.values());
		return ret;
	}
	
	protected abstract int getTimeKey(Interval i);
	protected abstract Interval getIntervalPertanyent(Interval i);
	protected abstract int getLimit();
	protected abstract Predicate<ReservaSoci> createPredicate();

}
