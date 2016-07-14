package Domini.Model.Esports;

import Domini.Model.Pista;
import Domini.Model.Restriccions.Pistes.IRestriccionsPistes;

public interface IEsport {
	public IRestriccionsPistes getRestriccions();
	
	public boolean PistaEsEsport(Pista p);
	public String getNomEsport();
}
