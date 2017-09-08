package Domini.CasosUs.Controladors.PujarSocis;

public class QuotaInvalida extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "El tipus de quota no es vàlida";
	}

}
