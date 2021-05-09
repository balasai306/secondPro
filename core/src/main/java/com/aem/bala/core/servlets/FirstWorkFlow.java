package com.aem.bala.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;

@Component(service = Servlet.class)
@SlingServletPaths(value= {"/bin/firstworkflow"})


public class FirstWorkFlow extends SlingSafeMethodsServlet {

	private static Logger log = LoggerFactory.getLogger(FirstWorkFlow.class);

	@Override
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse res) throws IOException {

		String status = "Excetuing workflow";

		final ResourceResolver resourceResolver = req.getResourceResolver();
		String payload = req.getRequestParameter("page").getString();
		try {
			if (StringUtils.isNotBlank(payload)) {
				WorkflowSession wfs = resourceResolver.adaptTo(WorkflowSession.class);
				WorkflowModel wfm = wfs.getModel("/var/workflow/models/Flow1");
				WorkflowData wfd = wfs.newWorkflowData("JCR_PATH", payload);
				status = wfs.startWorkflow(wfm, wfd).getState();

			}

		} catch (Exception e) {
			log.info("\n error work flow", e.getMessage());
		}
		res.setContentType("application/json");
		res.getWriter().write(status);

	}
}
