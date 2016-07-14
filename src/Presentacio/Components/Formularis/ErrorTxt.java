package Presentacio.Components.Formularis;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.Components.SingleWebComponent;

public class ErrorTxt extends SingleWebComponent {

	@Override
	protected void writeContent() throws IOException, ServletException {
		super.Append("<div class=\"help-block with-errors\"></div>");
	}

}
