package Domini.CasosUs.Controladors.PujarSocis;

public class QuotaInvalida extends Exception{

	@Override
	public String toString() {
		return "El tipus de quota no es vàlida";
	}

}
