package Communicacio.Xarxa.Domini.Entitats;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

import Communicacio.Dades.Info;

public class FactoriaEntitats {
	private static FactoriaEntitats instance = new FactoriaEntitats();
	public static FactoriaEntitats getInstance(){return instance;}

	private EntitatUsuari u = new EntitatUsuari();
	private EntitatSoci s = new EntitatSoci();
	private EntitatPista p = new EntitatPista();
	private EntitatCalendari c = new EntitatCalendari();
	private EntitatObertura o = new EntitatObertura();
	private EntitatOcupacio oc = new EntitatOcupacio();
	private EntitatHoraris oh = new EntitatHoraris();
	private EntitatOcupacions occ = new EntitatOcupacions();
	private EntitatReserva r = new EntitatReserva();
	private EntitatFranges f = new EntitatFranges();
	private EntitatCalendariOcupacions cs = new EntitatCalendariOcupacions();
	
	private Map<String,Entitat> entitats;
	
	public FactoriaEntitats(){
		entitats = new HashMap<>();
		entitats.put(s.getEntitat(), s);
		entitats.put(u.getEntitat(), u);
		entitats.put(p.getEntitat(), p);
		entitats.put(c.getEntitat(), c);
		entitats.put(o.getEntitat(), o);
		entitats.put(oc.getEntitat(), oc);
		entitats.put(oh.getEntitat(), oh);
		entitats.put(occ.getEntitat(), occ);
		entitats.put(r.getEntitat(), r);
		entitats.put(f.getEntitat(), f);
		entitats.put(cs.getEntitat(), cs);
	}
	
	public Entitat getEntitat(String entitat) throws EntitatInvalida{
		if (entitats.containsKey(entitat)) return entitats.get(entitat);
		else throw new EntitatInvalida();
	}
	
	public Info construir(ServletRequest req,String entitat) throws Exception{
		return getEntitat(entitat).crearInfo(req);
	}
	
	
	public String getUsuari(){
		return u.getEntitat();
	}
	
	public String getPista(){
		return p.getEntitat();
	}
	
	public String getSoci(){
		return s.getEntitat();
	}
	
	public String getCalendari(){
		return c.getEntitat();
	}
	
	public String getObertura(){
		return o.getEntitat();
	}

	public String getOcupacio() {
		return oc.getEntitat();
	}
	
	public String getHoraris(){
		return oh.getEntitat();
	}

	public String getOcupacions() {
		return occ.getEntitat();
	}

	public String getReserva() {
		return r.getEntitat();
	}
	public String getFranges(){
		return f.getEntitat();
	}
	public String getCalendariSetmanal(){
		return cs.getEntitat();
	}
}
