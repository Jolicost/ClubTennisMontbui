package Domini.Model.Esports;

import Domini.Model.Pista;
import Domini.Model.Restriccions.Pistes.IRestriccionsPistes;

public class EFronto implements IEsport {

	@Override
	public IRestriccionsPistes getRestriccions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean PistaEsEsport(Pista p) {
		return p.EsFronto();
	}

	@Override
	public String getNomEsport() {
		return "frontennis";
	}

}
