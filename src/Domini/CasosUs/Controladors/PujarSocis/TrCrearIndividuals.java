package Domini.CasosUs.Controladors.PujarSocis;

import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.PujarSocis.InfoPujarSoci;
import Domini.Model.Soci;
import Domini.Model.Quotes.Individual;

public class TrCrearIndividuals {

	private Set<InfoPujarSoci> individuals;
	private Set<Soci> resultat;
	
	public TrCrearIndividuals(Set<InfoPujarSoci> individuals) {
		this.individuals = individuals;
	}

	public void Executar() throws Exception{
		resultat = new HashSet<>();
		for (InfoPujarSoci is: individuals){
			Individual i = is.crearIndividual();
			Soci s = is.crearSoci();
			s.canviarQuota(i);
			resultat.add(s);
		}
	}

	public Set<Soci> getResultat() {
		return resultat;
	}
}
