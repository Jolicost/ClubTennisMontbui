package Presentacio.Components.Gestors.Usuari;

import Communicacio.Dades.Info;
import Presentacio.Components.MultipleWebComponent;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.TagBuilder.RowTag;

public class VistaInsertUsuari extends VistaInsertIndividual {

	@Override
	protected void createComponents() {
		super.setMainTag(new RowTag());
		super.AddComponent(new FormulariInsertUsuari());
	}

}
