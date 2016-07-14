package Communicacio.Identificacio;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class IdentificacioTomCat extends Identificacio{


	
	public IdentificacioTomCat(ServletRequest r){
		super();
		this.id = r.getRemoteAddr();
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
