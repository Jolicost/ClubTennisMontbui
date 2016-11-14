package Domini.MetaCasosUs.Recuperacio;

import Domini.MetaCasosUs.Recuperacio.Claus.ISistemaClausVolatils;
import Domini.MetaCasosUs.Recuperacio.Claus.SistemaClaus;

public class FactoriaRecuperacio {
	private static FactoriaRecuperacio instance = new FactoriaRecuperacio();
	public static FactoriaRecuperacio getInstance(){return instance;}
	
	public ISistemaClausVolatils claus = new SistemaClaus();
	
	public ISistemaClausVolatils getDipositClaus(){return claus;}
	
	
}
