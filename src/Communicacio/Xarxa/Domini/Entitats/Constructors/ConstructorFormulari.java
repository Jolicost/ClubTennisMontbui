package Communicacio.Xarxa.Domini.Entitats.Constructors;

import javax.servlet.ServletRequest;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.EntitatInvalida;

public class ConstructorFormulari extends ConstructorEntitat {

	@SuppressWarnings("unchecked")
	@Override
	public Info construir(Info in, ServletRequest req) throws IllegalArgumentException, IllegalAccessException, EntitatInvalida {
		return in.Populate(req.getParameterMap());
	}

}
