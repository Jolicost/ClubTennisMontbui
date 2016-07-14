package Communicacio.Xarxa.Domini.Entitats.Ocupacio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Communicacio.Dades.Reserves.InfoOcupacio;
import Communicacio.Excepcions.EntitatInvalida;
import Domini.Model.Reserves.Ocupacio;

public class FactoriaTipusOcupacio {
	private static FactoriaTipusOcupacio instance = new FactoriaTipusOcupacio();
	public static FactoriaTipusOcupacio getInstance(){return instance;}
	
	private EntitatAltres ea = new EntitatAltres();
	private EntitatCursets ec = new EntitatCursets();
	private EntitatManteniment em = new EntitatManteniment();
	
	private Map<String,EntitatTipusOcupacio> values;
	public FactoriaTipusOcupacio(){
		values = new HashMap<>();
		
		values.put(ea.getNom(), ea);
		values.put(ec.getNom(), ec);
		values.put(em.getNom(), em);
	}
	
	public String getAltres(){return ea.getNom();}
	public String getCursets(){return ec.getNom();}
	public String getManteniment(){return em.getNom();}
	
	public EntitatTipusOcupacio get(String nom) throws EntitatInvalida{
		if (values.containsKey(nom)) return values.get(nom);
		else throw new EntitatInvalida();
	}
	
	public Set<String> getAll(){
		Set<String> ret = new HashSet<>();
		values.values().forEach(v -> ret.add(v.getNom()));
		return ret;
	}
	
	public Ocupacio getOcupacio(String nom) throws EntitatInvalida{
		return get(nom).getTipusOcupacio();
	}
	
	public InfoOcupacio createInfo(String nom) throws EntitatInvalida{
		return get(nom).getInfoOcupacio();
	}
}
