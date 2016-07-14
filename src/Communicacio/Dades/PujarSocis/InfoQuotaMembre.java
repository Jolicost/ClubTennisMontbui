package Communicacio.Dades.PujarSocis;

import java.util.Map;

import Domini.CasosUs.Controladors.PujarSocis.SociNoMembre;
import Domini.CasosUs.Controladors.PujarSocis.TitularNoTrobat;
import Domini.Excepcions.SociNoTitular;
import Domini.Model.Soci;
import Domini.Model.Quotes.Membre;
import Domini.Model.Quotes.Quota;
import Domini.Model.Quotes.Titular;

public class InfoQuotaMembre extends InfoQuota{

	private int titular;

	public int getTitular() {
		return titular;
	}

	public void setTitular(int titular) {
		this.titular = titular;
	}
	
	private Titular seleccionarTitular(Map<Integer,Titular> titulars) throws TitularNoTrobat{
		if (titulars.containsKey(titular)) return titulars.get(titular);
		else throw new TitularNoTrobat();
	}

	public Membre crearMembre(Map<Integer,Titular> titulars) throws TitularNoTrobat, SociNoMembre, SociNoTitular{
		Titular titular = seleccionarTitular(titulars);
		Membre ret = new Membre();
		titular.AfegirMembre(ret);
		return ret;
	}

	public boolean EsMembre(){
		return true;
	}
}
