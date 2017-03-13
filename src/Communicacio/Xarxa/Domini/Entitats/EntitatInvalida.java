package Communicacio.Xarxa.Domini.Entitats;

public class EntitatInvalida extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Problema en la comunicació de les entitats";
	}

}
