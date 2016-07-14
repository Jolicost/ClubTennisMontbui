package Domini.Model.Restriccions.Filtre;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.Interval;

import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Restriccions.*;

public class FiltreRestriccions {

	public FiltreRestriccions(Soci s, Pista p, Set<Interval> oberts) {
		super();
		this.s = s;
		this.p = p;
		this.i = oberts;
	}
	
	protected Soci s;
	protected Pista p;
	protected Set<Interval> i;
	
	protected Set<Interval> resultat;
	
	public Set<Interval> getResultat(){
		return resultat;
	}
	public void Executar(){
		resultat = new HashSet<>();
		Set<Set<Interval>> possibles = new HashSet<>();
		for (IRestriccio res : crearRestriccions()){
			possibles.add(res.Filtrar(i));
		}
		
		for (Set<Interval> u : possibles){
			resultat.addAll(u);
		}
		
		RestriccioSenseReservaExclosio ex = new RestriccioSenseReservaExclosio(s);
		
		resultat = ex.Filtrar(resultat);
		
		RestriccioPista rp = new RestriccioPista(p,s);
		resultat = rp.Filtrar(resultat);
	}
	
	
	private Set<IRestriccio> crearRestriccions(){
		Set<IRestriccio> ret = new HashSet<>();
		ret.add(new RestriccioSenseReserva(s));
		ret.add(new RestriccioAnticipada(s));
		ret.add(new RestriccioInvitacio(s));
		return ret;
	}
	
	
}
