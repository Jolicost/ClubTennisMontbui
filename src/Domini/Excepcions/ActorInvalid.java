package Domini.Excepcions;

public class ActorInvalid extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "El teu rol no �s v�lid per a l'acci� demanada";
	}

}
