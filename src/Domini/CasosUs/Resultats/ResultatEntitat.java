package Domini.CasosUs.Resultats;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;

import Communicacio.Descriptors.DescriptorGestor;
import Communicacio.Descriptors.FactoriaDescriptors;
import Communicacio.Excepcions.DescriptorInvalid;
import Presentacio.Controladors.UseCaseWebBuilder;

public class ResultatEntitat extends ResultatCasUs {

	public ResultatEntitat(){
		
	}
	public ResultatEntitat(String entitat) {
		super();
		this.entitat = entitat;
	}

	protected String entitat;
	protected String descriptorGestor;
	
	public String getEntitat() {
		return entitat;
	}

	public void setEntitat(String entitat) {
		this.entitat = entitat;
	}
	
	
	public void setDescriptorGestor(String descriptorGestor) {
		this.descriptorGestor = descriptorGestor;
	}
	
	
	public DescriptorGestor getDescriptorGestor() throws DescriptorInvalid{
		return FactoriaDescriptors.getInstance().get(descriptorGestor);
	}
	
	protected Map<String,Object> createParameters(){
		Map<String,Object> pars = super.createParameters();
		pars.put("entitat",entitat);
		pars.put("descriptor", descriptorGestor);
		return pars;
	}
	

	
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception{
		this.PopulateParameters(w);
		w.Create(getDescriptorGestor().getPaginaGestor());
	}
	
}
