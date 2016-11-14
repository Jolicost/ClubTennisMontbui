package Domini.CasosUs.Resultats.Generals;

import java.io.IOException;

import javax.servlet.ServletException;

import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaCanviarContrasenya;

public class ResultatCanviarContrasenya extends ResultatCasUs {

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception {
		w.Create(new PaginaCanviarContrasenya());
	}

}
