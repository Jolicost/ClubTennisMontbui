package Domini.Model.Transaccions;

import Dades.Excepcions.BDExcepcio;
import Dades.Excepcions.NoExisteix;
import Domini.Model.Pista;
import Domini.Model.Calendaris.CalendariSetmanal;
import Factories.FactoriaControladors;

public abstract class Transaccio {
	public abstract void Executar() throws Exception;
	
	protected Pista LlegirPista(int id) throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlPista().get(id);
	}
	protected CalendariSetmanal LlegirCalendari(int id) throws BDExcepcio{
		//TODO: CREAR EL CONTROLADOR
		throw new NoExisteix();
	}
}
