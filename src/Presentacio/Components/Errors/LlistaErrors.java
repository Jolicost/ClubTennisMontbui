package Presentacio.Components.Errors;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;

import Presentacio.Components.SingleWebComponent;
import Presentacio.TagBuilder.CenteredDesktopColumnTag;
import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.Lists.ListElementTag;
import Presentacio.TagBuilder.Lists.ListTag;

public class LlistaErrors extends SingleWebComponent {

	private List<String> errors;
	private List<String> success;
	public LlistaErrors(){
		//CreateTags();
		errors = new LinkedList<>();
		success = new LinkedList<>();
	}
	
	private void CreateTags(){
		super.addTag(new CenteredDesktopColumnTag());
		super.addTag(new ListTag());
	}
	public LlistaErrors(List<String> errors,List<String> success){
		//CreateTags();
		this.errors = errors;
		this.success = success;
	}
	
	public void AddError(String error){
		errors.add(error);
	}
	public void AddSuccess(String success){
		this.success.add(success);
	}
	@Override
	protected void writeContent() throws IOException, ServletException {

		super.IncludeFile("Components/Notificacions/notificacions.jsp");
	}

}
