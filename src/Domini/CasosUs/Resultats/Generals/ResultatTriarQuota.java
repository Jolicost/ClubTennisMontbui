package Domini.CasosUs.Resultats.Generals;

import java.io.IOException;

import javax.servlet.ServletException;

import Domini.CasosUs.Resultats.ResultatEntitat;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaSeleccionarQuota;

public class ResultatTriarQuota extends ResultatEntitat {

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception {
		w.Create(new PaginaSeleccionarQuota());
	}

}
