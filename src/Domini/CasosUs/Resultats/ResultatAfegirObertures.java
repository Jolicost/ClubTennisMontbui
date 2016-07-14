package Domini.CasosUs.Resultats;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaAfegirObertures;

public class ResultatAfegirObertures extends ResultatEntitat {

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws Exception {
		this.PopulateParameters(w);
		w.Create(new PaginaAfegirObertures());
	}

}
