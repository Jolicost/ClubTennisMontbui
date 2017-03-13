package Communicacio.Dades.PujarSocis;

import java.util.Map;

import Communicacio.Dades.Info;
import Domini.CasosUs.Controladors.PujarSocis.SociNoIndividual;
import Domini.CasosUs.Controladors.PujarSocis.SociNoMembre;
import Domini.CasosUs.Controladors.PujarSocis.TitularNoTrobat;
import Domini.Excepcions.SociNoTitular;
import Domini.Model.Quotes.Individual;
import Domini.Model.Quotes.Membre;
import Domini.Model.Quotes.Titular;

public abstract class InfoQuota extends Info{

	public boolean EsTitular(){
		return false;
	}
	public boolean EsIndividual(){
		return false;
	}
	public boolean EsMembre(){
		return false;
	}
	
	public Membre crearMembre(Map<Integer,Titular> titulars) throws TitularNoTrobat, SociNoMembre, SociNoTitular{
		throw new SociNoTitular();
	}
	
	public Individual crearIndividual() throws SociNoIndividual{
		throw new SociNoIndividual();
	}
	public Titular crearTitular() throws SociNoTitular{
		throw new SociNoTitular();
	}
}
