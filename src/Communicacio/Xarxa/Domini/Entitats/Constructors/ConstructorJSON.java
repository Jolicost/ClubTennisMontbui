package Communicacio.Xarxa.Domini.Entitats.Constructors;

import javax.servlet.ServletRequest;

import Communicacio.Dades.Info;

public class ConstructorJSON extends ConstructorEntitat {

	@Override
	public Info construir(Info in, ServletRequest req) {
		String info = req.getParameter("info");
		return in.toInfo(info);
	}

}
