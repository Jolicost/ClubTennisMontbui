package Domini.Model.Rang;

public class Monitor extends Rang {

	@Override
	public String toString() {
		return "Monitor";
	}

	@Override
	public int getPermis() {
		return FactoriaRangs.getInstance().getNormal().getPermis() + 1;
	}

	@Override
	public RangType toRangType() {
		return RangType.Monitor;
	}

}
