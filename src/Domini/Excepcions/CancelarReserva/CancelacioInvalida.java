package Domini.Excepcions.CancelarReserva;

public class CancelacioInvalida extends Exception {

	private String motiu;
	public CancelacioInvalida(String motiu){
		this.motiu = motiu;
	}
	@Override
	public String toString() {
		return "No pots cancelar la reserva, motiu: " + motiu;
	}
	
	
}
