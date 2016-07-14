package Presentacio.Components.Formularis.Inputs.Usuari;

import Domini.Model.Rang.FactoriaRangs;
import Presentacio.Components.Formularis.Inputs.ListInput;

public class RangList extends ListInput{


	public RangList(String initValue) {
		super("rang","rang");
		for (String s: FactoriaRangs.getInstance().getAll())
			super.AddValue(s);
		super.setInitialValue(initValue);
	}
	
	public RangList() {
		super("rang","rang");
		for (String s: FactoriaRangs.getInstance().getAll())
			super.AddValue(s);
	}

	@Override
	protected String getLabelName() {
		return "Rang: ";
	}

}
