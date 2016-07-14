package Presentacio.Servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import Communicacio.Identificacio.IdentificadorsWeb;
import Domini.CasosUs.Descriptors.Generals.CasUsCrearMenuPrincipal;

/**
 * Servlet Filter implementation class FiltreGlobal
 */
@WebFilter("/*")
public class FiltreGlobal implements Filter {

    /**
     * Default constructor. 
     */
    public FiltreGlobal() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		IdentificadorsWeb.getInstance().get(request).Connection();
		
		CasUsCrearMenuPrincipal cu = new CasUsCrearMenuPrincipal();
		try {
			IdentificadorsWeb.getInstance().get(request).getSessio().FerCasDUsIndividual(cu).PopulateParameters(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
