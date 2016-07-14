package Presentacio.Components;

import java.io.IOException;

import javax.servlet.ServletException;

public class ServletComponent extends SingleWebComponent {

	private String file;
	public ServletComponent(String file){
		this.file = file;
	}
	@Override
	protected void writeContent() throws IOException, ServletException {
		super.IncludeFile(file);
	}
	@Override
	protected void writeStart() throws IOException, ServletException {

	}
	@Override
	protected void writeEnd() throws IOException, ServletException {

	}

}
