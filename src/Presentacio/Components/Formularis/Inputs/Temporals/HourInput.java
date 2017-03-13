package Presentacio.Components.Formularis.Inputs.Temporals;

import Presentacio.Components.Formularis.Inputs.InputZone;
import Presentacio.Components.Formularis.Inputs.InputZoneText;
import Presentacio.Components.Formularis.Inputs.LabelInput;

public class HourInput extends LabelInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HourInput(){
		super();
		super.setType(getInputType());
		super.setLabel(getLabelName());
	}
	
	public HourInput(String name,String id){
		super();
		super.setType(getInputType());
		super.setName(name);
		super.setId(id);
		super.setLabel(getLabelName());
	}

	protected String getLabelName(){return super.name;}
	protected String getInputType(){return "time";}
	@Override
	protected InputZone getInputZone() {
		return new InputZoneText();
	}

}
