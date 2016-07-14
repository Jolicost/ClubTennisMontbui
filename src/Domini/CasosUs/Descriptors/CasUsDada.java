package Domini.CasosUs.Descriptors;

import Communicacio.Dades.Info;

public abstract class CasUsDada extends CasUs{

	protected Info dada;
	public CasUsDada(){
		
	}
	public CasUsDada(Info dada) {
		super();
		this.dada = dada;
	}

	public Info getDada() {
		return dada;
	}

	public void setDada(Info dada) {
		this.dada = dada;
	}
	
}
