package com.aem.bala.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.bala.core.services.CreatingPage;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/csvToPage" })
public class PageCreation extends SlingSafeMethodsServlet {

	private static final Logger LOG = LoggerFactory.getLogger(PageCreation.class);
	@Reference
	CreatingPage creatingPage;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("hello");
			response.setContentType("text/plain");
			int pagesCreated = creatingPage.createPage();
			if (pagesCreated >0) {
				LOG.info("page is created" + pagesCreated);
				out.println(pagesCreated + " are created");

			} else {
				LOG.error("Page is not created");
				out.println("page is not created");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

	}

}
