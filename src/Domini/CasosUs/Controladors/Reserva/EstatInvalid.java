package Domini.CasosUs.Controladors.Reserva;

public class EstatInvalid extends Exception {

	@Override
	public String toString() {
		return "L'estat de la reserva no �s valid, torna-ho a provar des de zero";
	}

}
