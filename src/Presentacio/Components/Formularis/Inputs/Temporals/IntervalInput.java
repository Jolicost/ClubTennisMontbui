package Presentacio.Components.Formularis.Inputs.Temporals;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.TagBuilder.TagFactory;

public class IntervalInput extends MultipleWebComponent{

	private String horai;
	private String horaf;
	public IntervalInput(String horai,String horaf){
		this.horai = horai;
		this.horaf = horaf;
	}
	public IntervalInput(){
		
	}
	@Override
	protected void createComponents() {
		super.setMainTag(TagFactory.getInstance().getNullTag());
		super.AddComponent(getHoraInici());
		super.AddComponent(getHoraFi());
	}
	
	protected HourInput getHoraInici(){
		if (horai == null) return new HourInput("inici","inici");
		else {
			HourInput ret = new HourInput("inici","inici");
			ret.setInitialValue(horai);
			return ret;
		}
	}
	
	protected HourInput getHoraFi(){
		if (horaf == null) return new HourInput("fi","fi");
		else {
			HourInput ret = new HourInput("fi","fi");
			ret.setInitialValue(horaf);
			return ret;
		}
	}
	
	

}
