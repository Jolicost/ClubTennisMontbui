package Presentacio.Components.Footer;

import java.io.IOException;

import javax.servlet.ServletException;
import org.joda.time.DateTime;

import Presentacio.Components.SingleWebComponent;

public class Copyright extends SingleWebComponent {

	public Copyright() {
		super();
	}

	@Override
	protected void writeContent()
			throws IOException, ServletException {
		super.Append("<h3 class=\"text-center\">Club Tennis Montbui <small>Copyright 2016-" + String.valueOf(DateTime.now().getYear()) + "</small></h3>\n");
	}

}
