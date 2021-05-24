package com.aem.bala.core.services;

//com.aem.bala.core.services.CustomWorkflow
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class, immediate = true, property = {
		"process.label" + "=customStep1",
		Constants.SERVICE_DESCRIPTION + "=Step1", Constants.SERVICE_VENDOR + "=Mindtree"

}

)
public class CustomWorkflow implements WorkflowProcess {
	private static final Logger log = LoggerFactory.getLogger(CustomWorkflow.class);

	@Override
	public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap arguments)
			throws WorkflowException {
		// TODO Auto-generated method stub
		try {
			String name = arguments.get("NAME", String.class);
			log.info("*****************************************");
			log.info("the name is " + name);
			log.info("*****************************************");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("error in custom work flow");
		}

	}

}
