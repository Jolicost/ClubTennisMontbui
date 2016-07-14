package Domini.CasosUs.Resultats.Generals;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;

import Communicacio.Dades.Info;
import Domini.CasosUs.Resultats.ResultatConjunt;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaSelector;

public class ResultatSeleccionarEntitat extends ResultatConjunt {

	public ResultatSeleccionarEntitat(Set<Info> conjunt) {
		super(conjunt);
	}

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception {
		this.PopulateParameters(w);
		w.Create(new PaginaSelector());
	}
	
	
}
