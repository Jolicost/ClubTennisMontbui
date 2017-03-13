package Presentacio.Components.Gestors.Botons;

public class BotonsCRUDCalendariSetmanal extends BotonsCRUD{

	@Override
	protected void createComponents() {
		super.createComponents();
		super.AddComponent(new BotoEditarFranges());
	}

}
