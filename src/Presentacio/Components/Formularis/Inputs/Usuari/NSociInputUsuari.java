package Presentacio.Components.Formularis.Inputs.Usuari;

import Presentacio.Components.Formularis.Inputs.Soci.NSociInput;

public class NSociInputUsuari extends NSociInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NSociInputUsuari(){
		super.setIsDisabled(true);
	}

	public NSociInputUsuari(String nsoci) {
		super(nsoci);
		super.setIsDisabled(true);
	}

	@Override
	protected String getInputName() {
		return "nsoci";
	}
}
