package Communicacio.Identificacio;

public class IdentificacioTomCat extends Identificacio{


	
	public IdentificacioTomCat(String id){
		super();
		this.id = id;
	}

	private String id;
	


	@Override
	public String getIdentificacio() {
		return id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
