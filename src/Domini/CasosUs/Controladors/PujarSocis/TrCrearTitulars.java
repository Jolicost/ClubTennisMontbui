package Domini.CasosUs.Controladors.PujarSocis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Communicacio.Dades.PujarSocis.InfoPujarSoci;
import Domini.Model.Soci;
import Domini.Model.Quotes.Titular;

public class TrCrearTitulars {

	public TrCrearTitulars(Set<InfoPujarSoci> titulars) {
		super();
		this.titulars = titulars;
	}

	private Set<InfoPujarSoci> titulars;
	private Map<Integer,Titular> quotesResult;
	private Set<Soci> socisResult;
	
	public void Executar() throws Exception{
		quotesResult = new HashMap<>();
		socisResult = new HashSet<>();
		
		for (InfoPujarSoci is : titulars){
			Soci s = is.crearSoci();
			Titular t = is.crearTitular();
			s.canviarQuota(t);
			
			quotesResult.put(s.getNumero(), t);
			socisResult.add(s);
		}
	}

	public Map<Integer, Titular> getQuotesResult() {
		return quotesResult;
	}

	public Set<Soci> getSocisResult() {
		return socisResult;
	}
}
