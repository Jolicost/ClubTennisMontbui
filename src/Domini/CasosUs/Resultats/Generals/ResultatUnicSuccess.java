package Domini.CasosUs.Resultats.Generals;

import java.util.ArrayList;
import java.util.List;

public class ResultatUnicSuccess extends ResultatSuccess {

	public ResultatUnicSuccess(String msg) {
		super(createList(msg));
	}
	
	private static List<String> createList(String msg){
		List<String> ret = new ArrayList<String>();
		ret.add(msg);
		return ret;
	}

}
