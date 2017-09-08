package Domini.MetaCasosUs.Recuperacio.Excepcions;

public class UsuariInexistent extends ExcepcioRecuperacioContrasenya {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "No existeix cap usuari amb el correu indicat";
	}

}
