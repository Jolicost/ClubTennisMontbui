package Domini.Model.Esports;

public class EsportInvalid extends Exception{

	@Override
	public String toString() {
		return "L'esport indicat no existeix en el sistema";
	}

}
