package Communicacio.Dades.PujarSocis;

import java.util.Map;

import Domini.Excepcions.SociNoTitular;
import Domini.Model.Soci;
import Domini.Model.Quotes.Quota;
import Domini.Model.Quotes.Titular;

public class InfoQuotaTitular extends InfoQuota {


	
	public boolean EsTitular(){
		return true;
	}
	
	public Titular crearTitular() throws SociNoTitular{
		return new Titular();
	}

}
