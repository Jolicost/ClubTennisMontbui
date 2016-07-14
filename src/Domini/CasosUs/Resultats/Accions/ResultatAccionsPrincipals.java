package Domini.CasosUs.Resultats.Accions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;

import Communicacio.Dades.Accions.InfoAccions;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.Components.ServletComponent;
import Presentacio.Controladors.UseCaseWebBuilder;

public class ResultatAccionsPrincipals extends ResultatCasUs{

	private InfoAccions accions;
	private InfoAccions usuari;
	public ResultatAccionsPrincipals(InfoAccions info,InfoAccions usuari){
		this.accions = info;
		this.usuari = usuari;
	}
	
	protected Map<String,Object> createParameters(){
		Map<String,Object> pars = super.createParameters();
		pars.put("MenuPrincipal", accions);
		pars.put("MenuUsuari", usuari);
		return pars;
	}

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception {
		this.PopulateParameters(w);
		w.Create(new ServletComponent("Components/NavBar/MenuPrincipal.jsp"));
	}

}
