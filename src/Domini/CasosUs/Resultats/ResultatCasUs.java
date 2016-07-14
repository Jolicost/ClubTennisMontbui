package Domini.CasosUs.Resultats;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import Communicacio.Descriptors.DescriptorGestor;
import Communicacio.Excepcions.DescriptorInvalid;
import Domini.CasosUs.Resultats.Reserva.ResultatReserva;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Controladors.WebBuilder;

public abstract class ResultatCasUs {

	
	public void PopulateParameters(WebBuilder w){
		Map<String,Object> pars = createParameters();
		for (String s: pars.keySet()){
			w.SetRequestParam(s, pars.get(s));
		}
	}
	
	public void PopulateParameters(ServletRequest req,ServletResponse res){
		Map<String,Object> pars = createParameters();
		for (String s: pars.keySet()){
			req.setAttribute(s, pars.get(s));
		}
	}
	
	public DescriptorGestor getDescriptorGestor() throws DescriptorInvalid{
		throw new DescriptorInvalid();
	}
	
	public boolean EsEscriptura(){
		return false;
	}
	
	public ResultatReserva toResultatReserva() throws ResultatInvalid{
		throw new ResultatInvalid();
	}
	
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception{

	}
	
	protected Map<String,Object> createParameters(){
		return new HashMap<>();
	}

}
