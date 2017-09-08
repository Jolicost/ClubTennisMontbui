package Domini.CasosUs.Resultats.Generals;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;

import Communicacio.Dades.Info;
import Domini.CasosUs.Resultats.ResultatConjunt;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaFrangesPubliques;

public class ResultatFrangesPubliques extends ResultatConjunt{

	public ResultatFrangesPubliques(Set<Info> all) {
		super(all);
	}

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception {
		super.PopulateParameters(w);
		w.Create(new PaginaFrangesPubliques());
	}

}
