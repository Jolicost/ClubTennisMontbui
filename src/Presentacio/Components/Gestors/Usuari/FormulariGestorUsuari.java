package Presentacio.Components.Gestors.Usuari;

import Communicacio.Dades.Info;
import Presentacio.Components.Formularis.Inputs.Soci.DniInput;
import Presentacio.Components.Formularis.Inputs.Soci.NameInput;
import Presentacio.Components.Formularis.Inputs.Soci.SurnamesInput;
import Presentacio.Components.Formularis.Inputs.Usuari.MailInput;
import Presentacio.Components.Formularis.Inputs.Usuari.NSociInputUsuari;
import Presentacio.Components.Formularis.Inputs.Usuari.RangList;

public class FormulariGestorUsuari extends FormulariEditUsuari {

	private String correu;
	private String name;
	private String surnames;
	private String dni;
	private String rang;
	private String nsoci;

	public FormulariGestorUsuari(Info i){
		correu = i.getAttribute("email");
		name = i.getAttribute("nom");
		surnames = i.getAttribute("cognoms");
		dni = i.getAttribute("dni");
		rang = i.getAttribute("rang");
		nsoci = i.getAttribute("nsoci");
	}
	@Override
	protected void createInputs() {
		
		super.createInputs();
		super.AddComponent(new NSociInputUsuari(nsoci));
		super.AddComponent(new RangList(rang));
	}
	
	@Override
	protected String getDispatcher() {
		return "submit";
	}
	
	protected MailInput getMailInput(){return new MailInput(correu);}
	protected NameInput getNameInput(){return new NameInput(name);}
	protected SurnamesInput getSurnamesInput(){return new SurnamesInput(surnames);}
	protected DniInput getDniInput(){return new DniInput(dni);}
	

	

}
