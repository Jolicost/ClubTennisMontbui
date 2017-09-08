package Domini.Model.Rang;

public class SuperAdmin extends Rang{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Superadmin";
	}

	@Override
	public int getPermis() {
		return FactoriaRangs.getInstance().getAdmin().getPermis() + 1;
	}

	@Override
	public RangType toRangType() {
		return RangType.SuperAdmin;
	}

}
