package Presentacio.Components.Formularis.Inputs.Temporals;

public class DiaInput extends DateInput {

	public DiaInput(){
		super("dia","dia");
		super.setIsRequired(true);
	}
	
	public DiaInput(String dia){
		super("dia","dia");
		this.setInitialValue(dia);
		super.setIsRequired(true);
	}
	
	protected String getLabelName(){return "Dia: ";}
	
}
