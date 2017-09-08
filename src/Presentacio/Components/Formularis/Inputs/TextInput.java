package Presentacio.Components.Formularis.Inputs;

public class TextInput extends LabelInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TextInput(){
		super();
		super.setType(getInputType());
		super.setLabel(getLabelName());
	}
	
	public TextInput(String name,String id){
		super();
		super.setType(getInputType());
		super.setName(name);
		super.setId(id);
		super.setLabel(getLabelName());
	}
	@Override
	protected InputZone getInputZone() {
		return new InputZoneText();
	}

	protected String getLabelName(){return "Camp: ";}
	protected String getInputType(){return "text";}

}
