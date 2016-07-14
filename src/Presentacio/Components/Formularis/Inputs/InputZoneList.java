package Presentacio.Components.Formularis.Inputs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import Presentacio.TagBuilder.CustomTag;

public class InputZoneList extends InputZone {

	private List<String> options;
	
	public InputZoneList(){
		options = new ArrayList<>();
	}
	
	public void AddOption(String option){
		options.add(option);
	}
	
	
	@Override
	protected String getTagType() {
		return "select";
	}
	

	@Override
	protected void writeContent() throws IOException, ServletException {
		for (String s: options){
			
			if (super.initValue != null && s.equals(super.initValue)){
				CustomTag t = new CustomTag();
				t.setTagName("option");
				t.setAttribute("selected","true");
				super.ww.WriteTagStart(t);
				super.Append(s);
				super.ww.WriteTagEnd(t);
			}
			else super.Append("<option>" + s + "</option>");
		}
		
	}


}
