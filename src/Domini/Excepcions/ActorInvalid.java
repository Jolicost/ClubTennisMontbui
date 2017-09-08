package Domini.Excepcions;

public class ActorInvalid extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "El teu rol no és vàlid per a l'acció demanada";
	}

}
