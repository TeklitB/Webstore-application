package com.webstoreapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//SpringMvcDispatcherServletInitializer class as similar to web.xml
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootApplicationContextConfig.class};
	}

	// we are telling DispatcherServlet about our controller classes and view files
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		/*
		 * the application name is just a context name where the application is
		 * deployed—it is totally under the control of how we configure the web server.
		 * This the application name in the URL pattern
		 */
		return new String[] { "/webstore/*" };
	}
}