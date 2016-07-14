package Domini.CasosUs.Controladors.PujarSocis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import Communicacio.Dades.PujarSocis.InfoPujarSoci;
import Domini.Excepcions.SociNoTitular;
import Domini.Model.Soci;
import Domini.Model.Quotes.Titular;

public class TrCrearSocis  {

	
	public TrCrearSocis(Set<InfoPujarSoci> socis,Set<Soci> actuals) {
		super();
		this.socis = socis;
		this.actuals = actuals;
	}


	private Set<InfoPujarSoci> socis;
	private Set<Soci> actuals;
	private Set<Soci> resultat;
	
	private Map<Integer,Titular> quotesTitulars;
	
	public void Executar() throws Exception{
		resultat = new HashSet<>();
		quotesTitulars = new HashMap<>();
		
		TractarSocisActuals();
		
		Set<InfoPujarSoci> titulars = new HashSet<>();
		Set<InfoPujarSoci> membres = new HashSet<>();
		Set<InfoPujarSoci> individuals = new HashSet<>();
		
		for (InfoPujarSoci s: socis){
			if (s.EsTitular()) titulars.add(s);
			else if (s.EsMembre()) membres.add(s);
			else if (s.EsIndividual()) individuals.add(s);
		}
		
		TrCrearTitulars tr = new TrCrearTitulars(titulars);
		tr.Executar();
		quotesTitulars.putAll(tr.getQuotesResult());
		
		resultat.addAll(tr.getSocisResult());
		
		TrCrearMembres trm = new TrCrearMembres(quotesTitulars,membres);
		trm.Executar();
		resultat.addAll(trm.getResult());
		
		TrCrearIndividuals tri = new TrCrearIndividuals(individuals);
		tri.Executar();
		resultat.addAll(tri.getResultat());	
		
	}
	
	private void TractarSocisActuals() throws SociNoTitular{
		Map<Integer,Soci> actualsMap = new HashMap<>();
		for (Soci s: actuals){
			if (s.EsTitular()){
				quotesTitulars.put(s.getNumero(),s.getTitular());
			}	
			
			actualsMap.put(s.getNumero(), s);
		}
		
		Predicate<InfoPujarSoci> p =  is -> actualsMap.containsKey(is.getNumero());
		this.socis.removeIf(p);
	}

	public Set<Soci> getResultat() {
		return resultat;
	}
}
