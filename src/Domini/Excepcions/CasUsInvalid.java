package Domini.Excepcions;

public class CasUsInvalid extends Exception {

	@Override
	public String toString() {
		return "L'estat de la petició és invàlid, torna-ho a provar des de zero";
	}

}
