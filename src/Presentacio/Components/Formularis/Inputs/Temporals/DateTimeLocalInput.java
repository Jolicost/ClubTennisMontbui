package Presentacio.Components.Formularis.Inputs.Temporals;

public class DateTimeLocalInput extends DateInput {

	public DateTimeLocalInput(){
		super();
		super.setType(getInputType());
		super.setLabel(getLabelName());
	}
	
	public DateTimeLocalInput(String name,String id,String label){
		super();
		super.setType(getInputType());
		super.setName(name);
		super.setId(id);
		super.setLabel(label);
	}
	
	protected String getInputType(){return "datetime-local";}
	
}
