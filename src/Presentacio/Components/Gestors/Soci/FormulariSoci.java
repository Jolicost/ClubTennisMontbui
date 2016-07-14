package Presentacio.Components.Gestors.Soci;

import Presentacio.Components.Formularis.Formulari;
import Presentacio.Components.Formularis.Inputs.Soci.AdrecaInput;
import Presentacio.Components.Formularis.Inputs.Soci.DniInput;
import Presentacio.Components.Formularis.Inputs.Soci.NSociInput;
import Presentacio.Components.Formularis.Inputs.Soci.NaixamentInput;
import Presentacio.Components.Formularis.Inputs.Soci.NameInput;
import Presentacio.Components.Formularis.Inputs.Soci.QuotaList;
import Presentacio.Components.Formularis.Inputs.Soci.SurnamesInput;
import Presentacio.Components.Formularis.Inputs.Soci.TelefonInput;

public abstract class FormulariSoci extends Formulari {

	@Override
	protected String getDispatcher() {
		return "submit";
	}

	@Override
	protected void createInputs() {
		this.AddComponent(getNSociInput());
		this.AddComponent(getNomInput());
		this.AddComponent(getCognomsInput());
		this.AddComponent(getDniInput());
		this.AddComponent(getTelefonInput());
		this.AddComponent(getAdrecaInput());
		this.AddComponent(getNaixamentInput());
	}
	
	protected abstract NSociInput getNSociInput();
	protected abstract NameInput getNomInput();
	protected abstract SurnamesInput getCognomsInput();
	protected abstract DniInput getDniInput();
	protected abstract TelefonInput getTelefonInput();
	protected abstract AdrecaInput getAdrecaInput();
	protected abstract NaixamentInput getNaixamentInput();
}	
