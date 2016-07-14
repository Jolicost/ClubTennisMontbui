package Domini.CasosUs.Resultats.Generals;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;

import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaHome;

public class ResultatDefecte extends ResultatCasUs {

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception {
		this.PopulateParameters(w);
		w.Create(new PaginaHome());
	}

	@Override
	protected Map<String, Object> createParameters() {
		return super.createParameters();
	}

}
