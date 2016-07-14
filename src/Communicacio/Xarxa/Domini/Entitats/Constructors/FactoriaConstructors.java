package Communicacio.Xarxa.Domini.Entitats.Constructors;

public class FactoriaConstructors {
	private static FactoriaConstructors instance = new FactoriaConstructors();
	public static FactoriaConstructors getInstance(){return instance;}
	
	private ConstructorEntitat json = new ConstructorJSON();
	private ConstructorEntitat form = new ConstructorFormulari();
	public ConstructorEntitat getJSON(){
		return json;
	}
	public ConstructorEntitat getFormulari(){
		return form;
	}
	
	
}
