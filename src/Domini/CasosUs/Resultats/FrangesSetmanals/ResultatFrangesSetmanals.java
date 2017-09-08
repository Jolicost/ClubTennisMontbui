package Domini.CasosUs.Resultats.FrangesSetmanals;

import java.io.IOException;

import javax.servlet.ServletException;

import Domini.CasosUs.Resultats.ResultatConjunt;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaEditarFranges;

public class ResultatFrangesSetmanals extends ResultatConjunt {

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception {
		this.PopulateParameters(w);
		w.Create(new PaginaEditarFranges());
	}

}
