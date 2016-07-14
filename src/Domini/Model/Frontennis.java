package Domini.Model;

import org.joda.time.Duration;

import Domini.Model.Esports.FactoriaEsports;
import Domini.Model.Restriccions.Pistes.IRestriccionsPistes;
import Factories.FactoriaNormes;

public class Frontennis extends Pista {

	
	public boolean EsFronto(){return true;}

	@Override
	public IRestriccionsPistes getRestriccions() {
		return FactoriaNormes.getInstance().getRestriccionsFrontennis();
	}

	@Override
	protected String getTipus() {
		return getNomEsport();
	}

	@Override
	public String getNomEsport() {
		return FactoriaEsports.getInstance().getFrontennis();
	}

	@Override
	protected double getPreuPerHora() {
		return 10;
	}
	
	@Override
	protected Duration getTempsReserva() {
		return new Duration(60 * 60 * 1000);
	}

}
