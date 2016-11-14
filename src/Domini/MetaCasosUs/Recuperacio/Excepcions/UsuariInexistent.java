package Domini.MetaCasosUs.Recuperacio.Excepcions;

public class UsuariInexistent extends ExcepcioRecuperacioContrasenya {

	@Override
	public String toString() {
		return "No existeix cap usuari amb el correu indicat";
	}

}
