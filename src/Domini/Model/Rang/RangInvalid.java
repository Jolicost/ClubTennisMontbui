package Domini.Model.Rang;

public class RangInvalid extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "El rang indicat no existeix en el sistema";
	}

}
