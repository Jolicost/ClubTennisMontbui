package Domini.CasosUs.Controladors.Reserva.Tipus;

public class NoPotReservarTipus extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "No tens dret a reservar aquest tipus de reserva";
	}

}
