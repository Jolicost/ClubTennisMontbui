package Domini.Model.Quotes;

import Factories.FactoriaNormes;

public class Individual extends Quota{



	@Override
	public String toString() {
		return "Individual";
	}

	@Override
	public int getReservesSetmana() {
		return 2;
	}


}
