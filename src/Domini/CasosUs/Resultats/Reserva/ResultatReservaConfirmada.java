package Domini.CasosUs.Resultats.Reserva;

import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaHome;

public class ResultatReservaConfirmada extends ResultatReserva {


	@Override
	public void CreatePage(UseCaseWebBuilder w) throws Exception {
		w.AddSuccess("La teva reserva s'ha realitzat correctament");
		PopulateParameters(w);
		w.Create(new PaginaHome());
	}
}
