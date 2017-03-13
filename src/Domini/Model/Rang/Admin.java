package Domini.Model.Rang;

public class Admin extends Rang {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Admin";
	}

	@Override
	public int getPermis() {
		return FactoriaRangs.getInstance().getMonitor().getPermis() + 1;
	}

	@Override
	public RangType toRangType() {
		return RangType.Admin;
	}

}
