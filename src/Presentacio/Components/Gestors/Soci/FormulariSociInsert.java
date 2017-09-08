package Presentacio.Components.Gestors.Soci;

import Presentacio.Components.Formularis.Inputs.Soci.AdrecaInput;
import Presentacio.Components.Formularis.Inputs.Soci.DniInput;
import Presentacio.Components.Formularis.Inputs.Soci.NSociInput;
import Presentacio.Components.Formularis.Inputs.Soci.NSociInputSoci;
import Presentacio.Components.Formularis.Inputs.Soci.NaixamentInput;
import Presentacio.Components.Formularis.Inputs.Soci.NameInput;
import Presentacio.Components.Formularis.Inputs.Soci.SurnamesInput;
import Presentacio.Components.Formularis.Inputs.Soci.TelefonInput;

public class FormulariSociInsert extends FormulariSoci{

	@Override
	protected NSociInput getNSociInput() {
		return new NSociInputSoci();
	}

	@Override
	protected NameInput getNomInput() {
		return new NameInput();
	}

	@Override
	protected SurnamesInput getCognomsInput() {
		return new SurnamesInput();
	}

	@Override
	protected DniInput getDniInput() {
		return new DniInput();
	}


	@Override
	protected TelefonInput getTelefonInput() {
		return new TelefonInput();
	}

	@Override
	protected AdrecaInput getAdrecaInput() {
		return new AdrecaInput();
	}

	@Override
	protected NaixamentInput getNaixamentInput() {
		return new NaixamentInput();
	}

}
