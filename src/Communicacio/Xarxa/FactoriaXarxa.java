package Communicacio.Xarxa;

public class FactoriaXarxa {
	private static FactoriaXarxa instance = new FactoriaXarxa();
	public static FactoriaXarxa getInstance(){return instance;}
	
	public Web getControladorWeb(){
		return Web.getInstance();
	}
	
}
