package Factories;

import Domini.Model.Restriccions.Pistes.IRestriccionsPistes;
import Domini.Model.Restriccions.Pistes.RestriccioFrontennis;
import Domini.Model.Restriccions.Pistes.RestriccioTennis;

public class FactoriaNormes {
	private static FactoriaNormes instance = new FactoriaNormes();
	public static FactoriaNormes getInstance(){return instance;}
	

	private IRestriccionsPistes rt = new RestriccioTennis();
	private IRestriccionsPistes rf = new RestriccioFrontennis();

	public IRestriccionsPistes getRestriccionsTennis(){
		return rt;
	}
	public IRestriccionsPistes getRestriccionsFrontennis(){
		return rf;
	}
	
	
}
