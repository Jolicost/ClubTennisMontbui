package Domini.Excepcions;

public class UsuariJaSoci extends Exception {
	@Override
	public String toString() {
		return "L'usuari ja és soci";
	}
}
