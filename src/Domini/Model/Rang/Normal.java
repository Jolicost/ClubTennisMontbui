package Domini.Model.Rang;

public class Normal extends Rang{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Normal";
	}

	@Override
	public int getPermis() {
		return 0;
	}

	@Override
	public RangType toRangType() {
		return RangType.Normal;
	}

}
