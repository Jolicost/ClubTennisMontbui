package Domini.Excepcions;

public class NoPotReservar extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "No pots realitzar la reserva";
	}
}
