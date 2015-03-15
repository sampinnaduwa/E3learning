package com.samith.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * The Class Initializer.
 */
public class Initializer implements WebApplicationInitializer {

		/* (non-Javadoc)
		 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
		 */
		public void onStartup(ServletContext servletContext)
				throws ServletException {
			AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
			ctx.register(WebAppConfig.class);

			servletContext.addListener(new ContextLoaderListener(ctx));

			ctx.setServletContext(servletContext);

			Dynamic servlet = servletContext.addServlet("dispatcher",
					new DispatcherServlet(ctx));
			servlet.addMapping("/");
			servlet.setLoadOnStartup(1);

		}
	}