package Presentacio.Components.Formularis.Inputs.Usuari;

public class ConfirmPassInput extends PassInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idTo;
	public ConfirmPassInput(String idTo) {
		super();
		super.setIsRequired(true);
		this.idTo = idTo;
	}
	
	public ConfirmPassInput(String id,String name,String idTo){
		super(id,name);
		super.setIsRequired(true);
		this.idTo = idTo;
	}


	@Override
	protected String getLabelName() {
		return "Confirmar Pass: ";
	}
	
	@Override
	public void InitContent() {
		super.InitContent();
		this.i.getFirstTag().appendAttribute("data-match","#" + idTo);
	}
}
