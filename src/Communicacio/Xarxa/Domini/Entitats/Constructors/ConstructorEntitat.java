package Communicacio.Xarxa.Domini.Entitats.Constructors;

import javax.servlet.ServletRequest;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.EntitatInvalida;

public abstract class ConstructorEntitat {

	
	public abstract <T extends Info> T construir(Info in,ServletRequest req) throws IllegalArgumentException, IllegalAccessException, EntitatInvalida;
}
