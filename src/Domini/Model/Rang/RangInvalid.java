package Domini.Model.Rang;

public class RangInvalid extends Exception{

	@Override
	public String toString() {
		return "El rang indicat no existeix en el sistema";
	}

}
