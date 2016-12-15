package Domini.Model.Esports;

import Domini.Model.Pista;
import Domini.Model.Restriccions.Pistes.IRestriccionsPistes;

public class ETennis implements IEsport{

	@Override
	public IRestriccionsPistes getRestriccions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean PistaEsEsport(Pista p) {
		return p.EsTennis();
	}

	@Override
	public String getNomEsport() {
		return "tennis";
	}

	@Override
	public int getMinimJugadors() {
		return 2;
	}

	@Override
	public int getMaximJugadors() {
		return 4;
	}

}
