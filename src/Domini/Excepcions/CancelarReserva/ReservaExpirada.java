package Domini.Excepcions.CancelarReserva;

public class ReservaExpirada extends CancelacioInvalida {

	public ReservaExpirada() {
		super("La reserva no �s activa");
	}

}
