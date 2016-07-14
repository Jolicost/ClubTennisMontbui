package Communicacio.Dades.PujarSocis;

import java.util.Map;

import Domini.CasosUs.Controladors.PujarSocis.SociNoIndividual;
import Domini.Excepcions.SociNoTitular;
import Domini.Model.Soci;
import Domini.Model.Quotes.Individual;
import Domini.Model.Quotes.Quota;
import Domini.Model.Quotes.Titular;

public class InfoQuotaIndividual extends InfoQuota {

	
	public boolean EsIndividual(){
		return true;
	}
	
	public Individual crearIndividual() throws SociNoIndividual{
		return new Individual();
	}

}
