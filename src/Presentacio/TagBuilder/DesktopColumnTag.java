package Presentacio.TagBuilder;

public class DesktopColumnTag extends ColumnTag {

	private static final String device = "md";
	
	public DesktopColumnTag(int prop,int offset){
		super(prop,offset);
	}
	
	public DesktopColumnTag(int prop){
		super(prop);
	}

	@Override
	protected String getColumnName() {
		return device;
	}
	

	

}
