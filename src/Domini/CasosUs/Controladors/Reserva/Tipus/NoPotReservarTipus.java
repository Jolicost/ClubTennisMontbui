package Domini.CasosUs.Controladors.Reserva.Tipus;

public class NoPotReservarTipus extends Exception {

	@Override
	public String toString() {
		return "No tens dret a reservar aquest tipus de reserva";
	}

}
