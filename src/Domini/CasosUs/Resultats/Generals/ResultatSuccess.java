package Domini.CasosUs.Resultats.Generals;

import java.util.List;

import Presentacio.Controladors.WebBuilder;

public class ResultatSuccess extends ResultatDefecte {

	private List<String> msgs;
	
	public ResultatSuccess(List<String> msgs){this.msgs = msgs;}

	@Override
	public void PopulateParameters(WebBuilder w) {
		super.PopulateParameters(w);
		for (String s: msgs) w.AddSuccess(s);
	}


	
	
}
