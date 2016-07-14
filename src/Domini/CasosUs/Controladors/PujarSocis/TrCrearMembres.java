package Domini.CasosUs.Controladors.PujarSocis;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Communicacio.Dades.PujarSocis.InfoPujarSoci;
import Domini.Model.Soci;
import Domini.Model.Quotes.Membre;
import Domini.Model.Quotes.Titular;

public class TrCrearMembres {

	
	public TrCrearMembres(Map<Integer, Titular> titulars, Set<InfoPujarSoci> membres) {
		super();
		this.titulars = titulars;
		this.membres = membres;
	}

	private Map<Integer,Titular> titulars;
	private Set<InfoPujarSoci> membres;
	private Set<Soci> result;
	
	public void Executar() throws Exception{
		result = new HashSet<>();
		for (InfoPujarSoci is : membres){
			Soci s = is.crearSoci();
			Membre m = is.crearMembre(titulars);
			s.canviarQuota(m);
			result.add(s);
		}
	}

	public Set<Soci> getResult() {
		return result;
	}
}
