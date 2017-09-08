package Presentacio.Components.Formularis.Inputs;

import java.util.ArrayList;
import java.util.List;

public class ListInput extends LabelInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> values;

	public ListInput(String name,String id){
		values = new ArrayList<>();
		super.setLabel(getLabelName());
		super.setName(name);
		super.setId(id);
	}
	@Override
	protected InputZone getInputZone() {
		InputZoneList ret = new InputZoneList();
		for (String s: values) ret.AddOption(s);
		return ret;
	}
	
	public void AddValue(String val){
		values.add(val);
	}
	
	protected String getLabelName(){return "Llista: ";}
	




}
