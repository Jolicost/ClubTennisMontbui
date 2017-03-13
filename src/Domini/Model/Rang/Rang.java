package Domini.Model.Rang;

import java.io.Serializable;
import java.util.Comparator;

public abstract class Rang implements Comparable<Rang>,Comparator<Rang>,Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract String toString();
	public boolean EsAdmin(){
		return false;
	}
	
	public abstract int getPermis();
	
	
	@Override
	public int compare(Rang o1, Rang o2) {
		return Integer.compare(o1.getPermis(), o2.getPermis());
	}
	@Override
	public int compareTo(Rang o) {
		return this.compare(this, o);
	}
	
	public abstract RangType toRangType();

}
