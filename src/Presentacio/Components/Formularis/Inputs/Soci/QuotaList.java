package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.ListInput;

public class QuotaList extends ListInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuotaList() {
		super("quota","quota");
		super.AddValue("Individual");
		super.AddValue("Familiar");
	}
	
	public QuotaList(String initValue) {
		super("quota","quota");
		super.setInitialValue(initValue);
		super.AddValue("Individual");
		super.AddValue("Familiar");
	}

	@Override
	protected String getLabelName() {
		return "Quota: ";
	}

}
