package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.LocalDate;

public abstract class IntervalUtils{

	public static Set<Interval> Intersaction(Set<Interval> x,Set<Interval> y){
		HashSet<Interval> ret = new HashSet<>();
		for (Interval i: x){
			ret.addAll(Intersaction(y,i));
		}
		return ret;
	}
	public static Set<Interval> Difference(Set<Interval> x,Set<Interval> y){
		Set<Interval> temp = new HashSet<>();
		temp.addAll(x);
		for (Interval j: y){
			temp = Difference(temp,j);
		}
		return temp;
	}
	
	

	
	private static Set<Interval> Difference(Set<Interval> x,Interval y){
		Set<Interval> ret = new HashSet<>();
		for (Interval i:x){
			ret.addAll(Difference(i,y));
		}
		return ret;
	}
	
	public static Set<Interval> Difference(Interval x,Set<Interval> y ){
		Set<Interval> temp = new HashSet<>();
		temp.add(x);
		for (Interval i : y){
			temp = Difference(temp,i);
		}
		return temp;
	}
	

	private static Set<Interval> Difference(Interval x,Interval y){
		Set<Interval> ret = new HashSet<>();
		if (x.overlaps(y)){
			Interval z = x.overlap(y);
			//Interval k = union(x,y);
			if (!x.getStart().equals(z.getStart())){
				Interval j = new Interval(x.getStart(),z.getStart());
				ret.add(j);
			}
			if (!x.getEnd().equals(z.getEnd())){
				Interval j = new Interval(z.getEnd(),x.getEnd());
				ret.add(j);
			}
		}
		else ret.add(x);
		return ret;
	}
	
	static Interval union( Interval firstInterval, Interval secondInterval ) 
	{
	    // Purpose: Produce a new Interval instance from the outer limits of any pair of Intervals.

	    // Take the earliest of both starting date-times.
	    DateTime start =  firstInterval.getStart().isBefore( secondInterval.getStart() )  ? firstInterval.getStart() : secondInterval.getStart();
	    // Take the latest of both ending date-times.
	    DateTime end =  firstInterval.getEnd().isAfter( secondInterval.getEnd() )  ? firstInterval.getEnd() : secondInterval.getEnd();
	    // Instantiate a new Interval from the pair of DateTime instances.
	    Interval unionInterval = new Interval( start, end );

	    return unionInterval;
	}
	public static Set<Interval> Intersaction(Set<Interval> x,Interval y){
		Set<Interval> ret = new HashSet<>();
		for (Interval i: x){
			if (i.overlaps(y)){
				ret.add(i.overlap(y));
			}
		}
		return ret;
	}
	public static Set<Interval> Split(Set<Interval> x,Duration dur){
		Set<Interval> ret = new HashSet<>();
		for (Interval i:x){
			List<Interval> l = Split(i,dur);
			if (l.size() > 1){
				int j = l.size() - 1;
				if (l.get(j).toDuration().isShorterThan(dur)){
					/* Last interval was cut, we need to merge them */
					DateTime start = l.get(j - 1).getStart();
					DateTime end = l.get(j).getEnd();
					Interval k = new Interval(start,end);
					l.remove(j);
					l.remove(j - 1);
					l.add(k);
				}
			}
			
			ret.addAll(l);
		}
		return ret;
	}
	
	public static List<Interval> Split(Interval x,Duration dur){
		DateTime start = x.getStart();
		DateTime end = x.getEnd();
		List<Interval> ret = new ArrayList<>();
		while (start.isBefore(end)){
			DateTime n = DateTime.now();
			/* Get the real end based on last interval gap */
			DateTime realend;
			if (start.plus(dur).isAfter(end)){
				realend = end;
			}
			else realend = start.plus(dur);
			
			if (realend.isAfter(n)){
				
				
				DateTime realstart;
				/* Get the real start in any case */
				if (start.isBefore(DateTime.now())){
					realstart = DateTime.now();
				}
				else{
					realstart = start;
				}
				
				

				ret.add(new Interval(realstart,realend));
			}	
			start = start.plus(dur);
		}
		return ret;
	}
	
	public static Map<LocalDate,Set<Interval>> SplitByDay(Set<Interval> in){
		Map<LocalDate,Set<Interval>> ret = new HashMap<>();
		
		for (Interval i:in){
			LocalDate dia = i.getStart().toLocalDate();
			if (ret.containsKey(dia)){
				ret.get(dia).add(i);
			}
			else{
				Set<Interval> conj = new HashSet<>();
				conj.add(i);
				ret.put(dia, conj);
			}
		}
		return ret;
	}
}
