package Domini.MetaCasosUs.Recuperacio.Claus;

import Domini.MetaCasosUs.Recuperacio.Excepcions.ExcepcioRecuperacioContrasenya;

public interface ISistemaClausVolatils {

	public String RequestKey(String correu) throws ExcepcioRecuperacioContrasenya;
	public String getRequesterEmail(String key) throws ExcepcioRecuperacioContrasenya;
	public void removeKey(String key) throws ExcepcioRecuperacioContrasenya;
}
