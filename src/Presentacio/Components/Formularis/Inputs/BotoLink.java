package Presentacio.Components.Formularis.Inputs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

public class BotoLink extends BotoEnviar {

	private String submit;
	private Map<String,String> params;
	public BotoLink(String nom,String id,String submit) {
		super(nom,id);
		this.submit = submit;
		params = new HashMap<>();
	}

	public void AddParameter(String id,String value){
		params.put(id, value);
	}
	@Override
	public void InitContent() {
		super.InitContent();
		
	}

	@Override
	protected void IncludeMetadata() throws IOException, ServletException {
		super.IncludeMetadata();
		super.io.setParam("id",super.getId());
		super.io.setParam("submit", submit);
		super.io.setParam("method", "get");
		super.io.setParam("parameters", params);
		super.IncludeFile("Components/Botons/botolink.jsp");
	}
	

}
