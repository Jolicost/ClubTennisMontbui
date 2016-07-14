package Presentacio.Main;

import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.Usuari.FormulariLogin;

public abstract class PaginaPrincipal extends Pagina{

	public PaginaPrincipal() {
		super();
		super.setTitle("Club Tennis Montbui");
	}
	
	@Override
	protected WebComponent createChild() throws Exception {
		return new VistaPrincipal(getMainComponent());
	}
	
	protected abstract WebComponent getMainComponent() throws Exception;


}
