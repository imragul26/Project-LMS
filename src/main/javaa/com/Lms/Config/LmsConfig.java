package com.Lms.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LmsConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class arr[] = { LmsAnnotationContainer.class };

		return arr;
	}

	@Override
	protected String[] getServletMappings() {

		String arr[] = { "/" };
		return arr;
	}

}
