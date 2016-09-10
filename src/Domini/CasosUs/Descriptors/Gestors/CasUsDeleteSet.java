package Domini.CasosUs.Descriptors.Gestors;

import java.io.Serializable;
import java.util.Set;

import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatEscriptura;

public class CasUsDeleteSet extends CasUsDelete {

	private Set<Serializable> ids;
	public CasUsDeleteSet(Set<Serializable> ids){
		this.ids = ids;
	}
	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		ResultatEntitat ret = new ResultatEscriptura();
		for (Serializable i: ids) gestor.Delete(i);
		return ret;
	}
}
