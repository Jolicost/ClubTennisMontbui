package Domini.CasosUs.Controladors.Reserva;

public class EstatInvalid extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "L'estat de la reserva no és valid, torna-ho a provar des de zero";
	}

}
