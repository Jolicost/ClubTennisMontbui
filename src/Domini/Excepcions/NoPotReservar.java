package Domini.Excepcions;

public class NoPotReservar extends Exception {
	@Override
	public String toString() {
		return "No pots realitzar la reserva";
	}
}
