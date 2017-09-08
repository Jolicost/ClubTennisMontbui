package Domini.Excepcions;

public class SociJaAssignat extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "El dni que has introduït ja està assignat a un altre usuari";
	}

}
