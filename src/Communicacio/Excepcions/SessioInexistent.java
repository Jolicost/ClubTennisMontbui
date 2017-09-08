package Communicacio.Excepcions;

public class SessioInexistent extends ExcepcioXarxa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "La sessió ha caducat";
	}
}
