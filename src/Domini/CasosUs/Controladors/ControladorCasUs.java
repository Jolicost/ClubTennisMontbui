package Domini.CasosUs.Controladors;

import java.util.Stack;

import Communicacio.Excepcions.CapGestor;
import Communicacio.Excepcions.GestorInvalid;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Gestors.Controlador.CuaCasosUs;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.CasosUs.Resultats.Generals.ResultatDefecte;
import Domini.Excepcions.CasUsInvalid;

public abstract class ControladorCasUs {

	protected Stack<CasUs> casos;
	protected Stack<ResultatCasUs> resultats;
	
	public ControladorCasUs(){
		casos = new Stack<>();
		resultats = new Stack<>();
	}
	public ResultatCasUs FerCasDUs(CasUs cu) throws Exception{
		
		if (cu.IsRoot()) {
			casos.clear();
			resultats.clear();
		}
		
		if (!casos.empty()) casos.peek().InitChild(cu);
		casos.add(cu);
		resultats.add(ferCasUs(cu));
		
		if (!resultats.isEmpty()){
			if (resultats.peek().EsEscriptura()){
				while (!casos.isEmpty() && !casos.peek().IsNeutral()){
					casos.pop();
				}
			}
			
			if (!casos.isEmpty()){
				if (casos.peek().IsNeutral()) {
					resultats.add(ferCasUs(casos.peek()));
				}
				return resultats.peek();
			}
			else return new ResultatDefecte();
			
			
		}
		else{
			return new ResultatDefecte();
		}
		
	}
	
	protected ResultatCasUs ferCasUs(CasUs cu) throws Exception{
		ResultatCasUs ret;
		cu.ferCasUs();
		ret = cu.getResultat();
		return ret;
	}
	
	public String getEntitatGestor()throws GestorInvalid, CapGestor, CasUsInvalid{
		if (!casos.isEmpty()){
			return casos.peek().toGestor().getEntitat();
		}
		else throw new GestorInvalid();
	}
	
	
	
}
