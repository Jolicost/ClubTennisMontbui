package Domini.Model.Rang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FactoriaRangs {
	private static FactoriaRangs instance = new FactoriaRangs();
	public static FactoriaRangs getInstance(){return instance;}
	
	private Rang admin;
	private Rang monitor;
	private Rang superadmin;
	private Rang normal;
	
	
	private Map<String,Rang> rangs;
	
	public FactoriaRangs(){
		admin = new Admin();
		monitor = new Monitor();
		superadmin = new SuperAdmin();
		normal = new Normal();
		
		crearMapa();
	}

	private void crearMapa() {
		rangs = new HashMap<>();
		rangs.put(admin.toString(), admin);
		rangs.put(normal.toString(), normal);
		rangs.put(superadmin.toString(), superadmin);
		rangs.put(monitor.toString(), monitor);
	}
	
	public Rang getRang(String r) throws RangInvalid{
		if (rangs.containsKey(r)) return rangs.get(r);
		else throw new RangInvalid();
	}
	
	public int compare(String r1,String r2) throws RangInvalid{
		return getRang(r1).compareTo(getRang(r2));
	}

	public Rang getAdmin() {
		return admin;
	}

	public Rang getMonitor() {
		return monitor;
	}

	public Rang getSuperadmin() {
		return superadmin;
	}

	public Rang getNormal() {
		return normal;
	}
	
	public Set<String> getAll(){
		Set<String> ret = new HashSet<>();
		ret.addAll(rangs.keySet());
		return ret;
	}

	
	
}
