package Utils;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

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

	private static Set<Interval> Difference(Interval x,Interval y){
		Set<Interval> ret = new HashSet<>();
		if (x.overlaps(y)){
			Interval z = x.overlap(y);
			Interval k = union(x,y);
			if (!k.getStart().equals(z.getStart())){
				Interval j = new Interval(k.getStart(),z.getStart());
				ret.add(j);
			}
			if (!k.getEnd().equals(z.getEnd())){
				Interval j = new Interval(z.getEnd(),k.getEnd());
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
		DateTime now = DateTime.now();
		for (Interval i:x){
			DateTime it = i.getStart();
			
			while (!it.plus(dur).isAfter(i.getEnd())){
				DateTime fi = it.plus(dur);
				if (now.isBefore(fi) && now.isAfter(it)){
					ret.add(new Interval(now,fi));
				}
				else{
					if (now.isBefore(it))
						ret.add(new Interval(it,it.plus(dur)));
				}
				
				it = it.plus(dur);
			}
		}
		return ret;
	}
}
