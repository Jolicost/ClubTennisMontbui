package Domini.Excepcions;

public class ContrasenyaIncorrecta extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Contrasenya Incorrecta";
	}

}
