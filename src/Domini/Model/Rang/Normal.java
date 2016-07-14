package Domini.Model.Rang;

public class Normal extends Rang{

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
