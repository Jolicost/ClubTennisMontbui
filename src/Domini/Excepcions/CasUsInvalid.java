package Domini.Excepcions;

public class CasUsInvalid extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "L'estat de la petició és invàlid, torna-ho a provar des de zero";
	}

}
