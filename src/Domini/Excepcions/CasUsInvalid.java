package Domini.Excepcions;

public class CasUsInvalid extends Exception {

	@Override
	public String toString() {
		return "L'estat de la petici� �s inv�lid, torna-ho a provar des de zero";
	}

}
