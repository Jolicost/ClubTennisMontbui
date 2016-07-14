package Domini.Excepcions;

import java.util.Arrays;

public class ActorInvalid extends Exception {

	@Override
	public String toString() {
		return "El teu rol no és vàlid per a l'acció demanada";
	}

}
