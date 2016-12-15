package Domini.CasosUs.Resultats.Reserva;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import Communicacio.Dades.Reserves.Participants.InfoTriarParticipants;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaTriarParticipants;

public class ResultatTriarParticipants extends ResultatReserva
{
	private InfoTriarParticipants info;
	
	public ResultatTriarParticipants(InfoTriarParticipants info){
		this.info = info;
	}

	public InfoTriarParticipants getInfo() {
		return info;
	}

	public void setInfo(InfoTriarParticipants info) {
		this.info = info;
	}

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception {
		this.PopulateParameters(w);
		w.Create(new PaginaTriarParticipants());
	}

	@Override
	protected Map<String, Object> createParameters() {
		Map<String,Object> ret = new HashMap<>();
		ret.put("info", info);
		return ret;
	}
	

	
}
