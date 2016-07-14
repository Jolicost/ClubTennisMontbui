package Domini.Model;

import org.joda.time.Duration;

import Domini.Model.Esports.FactoriaEsports;
import Domini.Model.Restriccions.Pistes.IRestriccionsPistes;
import Factories.FactoriaNormes;

public class Tennis extends Pista {

	public boolean EsTennis(){return true;}

	@Override
	public IRestriccionsPistes getRestriccions() {
		return FactoriaNormes.getInstance().getRestriccionsTennis();
	}

	@Override
	protected String getTipus() {
		return getNomEsport();
	}

	@Override
	public String getNomEsport() {
		return FactoriaEsports.getInstance().getTennis();
	}

	@Override
	protected double getPreuPerHora() {
		return 5;
	}

	@Override
	protected Duration getTempsReserva() {
		return new Duration(90 * 60 * 1000);
	}

}
