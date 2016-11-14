package Domini.CasosUs.Controladors.CanviContrasenya;

import Domini.CasosUs.Resultats.ResultatCasUs;

public interface ICasUsRecuperacio {

	public ResultatCasUs CanviarContrasenya(String key) throws Exception;
	public ResultatCasUs Submit(String password) throws Exception;
}
