package Domini.Excepcions.CancelarReserva;

public class CancelacioInvalida extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String motiu;
	public CancelacioInvalida(String motiu){
		this.motiu = motiu;
	}
	@Override
	public String toString() {
		return "No pots cancelar la reserva, motiu: " + motiu;
	}
	
	
}
