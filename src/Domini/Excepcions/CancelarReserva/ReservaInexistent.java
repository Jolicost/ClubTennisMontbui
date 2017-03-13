package Domini.Excepcions.CancelarReserva;

public class ReservaInexistent extends CancelacioInvalida {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReservaInexistent() {
		super("La reserva no existeix");
	}



}
