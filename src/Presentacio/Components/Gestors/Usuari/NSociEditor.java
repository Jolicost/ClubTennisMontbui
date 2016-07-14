package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.Components.Formularis.Inputs.Soci.NSociInput;
import Presentacio.TagBuilder.CenteredDesktopColumnTag;

public class NSociEditor extends MultipleWebComponent {

	private String n;
	public NSociEditor(String n){
		this.n = n;
	}
	@Override
	protected void createComponents() {
		if (n == null)
			super.AddComponent(new BotoAssignarSoci());
		else 
			super.AddComponent(new BotoDesassignarSoci());
	}

}
