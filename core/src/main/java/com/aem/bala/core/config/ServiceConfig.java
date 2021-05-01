package com.aem.bala.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "Second Project - OSGI Config", description = "OSGI Configuration for secondProject")

public @interface ServiceConfig {

	@AttributeDefinition(name = "ServiceName", description = " Enter Service name", type = AttributeType.STRING)
	public String serviceName();

	@AttributeDefinition(name = "Service Count", description = "Enter Number of Services", type = AttributeType.INTEGER)
	public int serviceCount();

	@AttributeDefinition(name = "Live Data", description = "Check the box for live data", type = AttributeType.BOOLEAN)
	public boolean serviceLiveData();

	@AttributeDefinition(name = "Region", description = "To add Region", type = AttributeType.STRING)
	public String[] serviceRegion() default { "India", "America" };

	@AttributeDefinition(name = "Run Mode", description = "Please select the run mode from below", options = {
			@Option(label = "Author", value = "author"), @Option(label = "Publish", value = "publish"),
			@Option(label = "Both", value = "both") }, type = AttributeType.STRING)
	public String serviceRunMode();

}
