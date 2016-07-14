package Presentacio.Components.Gestors.Soci;

import Communicacio.Dades.Info;
import Presentacio.Components.Formularis.Inputs.Soci.AdrecaInput;
import Presentacio.Components.Formularis.Inputs.Soci.DniInput;
import Presentacio.Components.Formularis.Inputs.Soci.NSociInput;
import Presentacio.Components.Formularis.Inputs.Soci.NSociInputSoci;
import Presentacio.Components.Formularis.Inputs.Soci.NaixamentInput;
import Presentacio.Components.Formularis.Inputs.Soci.NameInput;
import Presentacio.Components.Formularis.Inputs.Soci.QuotaList;
import Presentacio.Components.Formularis.Inputs.Soci.SurnamesInput;
import Presentacio.Components.Formularis.Inputs.Soci.TelefonInput;

public class FormulariSociUpdate extends FormulariSoci {

	private Info soci;
	public FormulariSociUpdate(Info i){
		this.soci = i;
	}
	@Override
	protected NSociInput getNSociInput() {
		return new NSociInputSoci(soci.getAttribute("numero"));
	}

	@Override
	protected NameInput getNomInput() {
		return new NameInput(soci.getAttribute("nom"));
	}

	@Override
	protected SurnamesInput getCognomsInput() {
		return new SurnamesInput(soci.getAttribute("cognoms"));
	}

	@Override
	protected DniInput getDniInput() {
		return new DniInput(soci.getAttribute("dni"));
	}

	@Override
	protected TelefonInput getTelefonInput() {
		return new TelefonInput(soci.getAttribute("telefon"));
	}
	@Override
	protected AdrecaInput getAdrecaInput() {
		return new AdrecaInput(soci.getAttribute("adreca"));
	}
	@Override
	protected NaixamentInput getNaixamentInput() {
		return new NaixamentInput(soci.getAttribute("naixament"));
	}

}
