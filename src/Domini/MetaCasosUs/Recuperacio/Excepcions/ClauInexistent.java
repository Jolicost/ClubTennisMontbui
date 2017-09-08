package Domini.MetaCasosUs.Recuperacio.Excepcions;

public class ClauInexistent extends ExcepcioRecuperacioContrasenya {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "La clau de recuperacio no existeix";
	}

}
