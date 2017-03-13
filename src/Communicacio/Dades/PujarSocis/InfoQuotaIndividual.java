package Communicacio.Dades.PujarSocis;

import Domini.CasosUs.Controladors.PujarSocis.SociNoIndividual;
import Domini.Model.Quotes.Individual;

public class InfoQuotaIndividual extends InfoQuota {

	
	public boolean EsIndividual(){
		return true;
	}
	
	public Individual crearIndividual() throws SociNoIndividual{
		return new Individual();
	}

}
