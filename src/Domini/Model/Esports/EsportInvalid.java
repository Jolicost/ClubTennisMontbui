package Domini.Model.Esports;

public class EsportInvalid extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "L'esport indicat no existeix en el sistema";
	}

}
