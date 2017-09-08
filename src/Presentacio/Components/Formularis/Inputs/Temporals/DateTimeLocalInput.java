package Presentacio.Components.Formularis.Inputs.Temporals;

public class DateTimeLocalInput extends DateInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
