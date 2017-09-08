package Domini.Excepcions.CancelarReserva;

public class ReservaExpirada extends CancelacioInvalida {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReservaExpirada() {
		super("La reserva no és activa");
	}

}
