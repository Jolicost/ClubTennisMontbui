package Presentacio.Components.Formularis.Inputs.Soci;

public class NSociInputSoci extends NSociInput{

	public NSociInputSoci(){
		super();
		super.setIsRequired(true);
	}
	public NSociInputSoci(String nsoci) {
		super(nsoci);
		super.setIsRequired(true);
	}
	@Override
	protected String getInputName() {
		return "numero";
	}
}
