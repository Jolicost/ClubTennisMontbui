package Domini.Model.Restriccions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

import Domini.Excepcions.InsuficientQuota;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;

public abstract class RestriccioReservaLimitada extends RestriccioReserva {

	public RestriccioReservaLimitada(Soci s,Pista p) {
		super(s,p);
	}

	@Override
	public Set<Interval> Filtrar(Set<Interval> in) {
		Set<Interval> ret = new HashSet<>();
		
		
		Set<Interval> in2 = new HashSet<>();
		for (Interval i: in) if (this.TestPista(i)) in2.add(i);
		
		for (Set<Interval> res : Separar(in2)){
			Predicate<ReservaSoci> p = this.createPredicate();
			Interval example = res.iterator().next();
			Interval per = this.getIntervalPertanyent(example);
			
			Predicate<ReservaSoci> espai = r -> r.Intersecciona(per);
			espai = p.and(espai);
			
			Set<ReservaSoci> mateixEspai = this.obtenirReservesRealitzades(s,espai);
			if (mateixEspai.size() < this.getLimit()){
				ret.addAll(res);
			}
		}
		return ret;
	}

	@Override
	public int Test(Interval in) throws NoPotReservar {
		if (!TestPista(in)) throw new NoPotReservar();
		Predicate<ReservaSoci> p = this.createPredicate();
		Interval per = this.getIntervalPertanyent(in);
		
		Predicate<ReservaSoci> espai = r -> r.Intersecciona(per);
		espai = p.and(espai);
		
		Set<ReservaSoci> mateixEspai = this.obtenirReservesRealitzades(s,espai);
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
	
	protected boolean TestAntelacio(Interval i) {
		Duration d = getMaximaAnticipacio();
		return !DateTime.now().plus(d).isBefore(i.getStart());
	}
	
	protected abstract boolean TestPista(Interval i);
	
	protected Set<ReservaSoci> obtenirReservesRealitzades(Soci s,Predicate<ReservaSoci> cond){
		 return s.getReservesCondicio(cond);
		
	}
	protected abstract int getTimeKey(Interval i);
	protected abstract Interval getIntervalPertanyent(Interval i);
	protected abstract int getLimit();
	protected abstract Duration getMaximaAnticipacio();
	protected abstract Predicate<ReservaSoci> createPredicate();
	


}
