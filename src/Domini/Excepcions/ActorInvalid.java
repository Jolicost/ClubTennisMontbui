package Domini.Excepcions;

import java.util.Arrays;

public class ActorInvalid extends Exception {

	@Override
	public String toString() {
		return "El teu rol no �s v�lid per a l'acci� demanada";
	}

}
