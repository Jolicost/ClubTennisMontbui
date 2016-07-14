package Communicacio.Excepcions;

public class SessioInexistent extends ExcepcioXarxa{

	@Override
	public String toString() {
		return "La sessió ha caducat";
	}
}
