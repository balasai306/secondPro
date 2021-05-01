package com.aem.bala.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Osgi Factory Config", description = "this is a OSGI factory config")


	public @interface OsgiFactoryConfig {
		@AttributeDefinition(name = " config id", description = "enter id", type = AttributeType.INTEGER)
		public int configId();

		@AttributeDefinition(name = "service Name", description = "enter service name", type = AttributeType.STRING)
		public String serviceName() default "service";

		@AttributeDefinition(name = "service URL", description = "enter service URL", type = AttributeType.STRING)
		public String serviceUrl() default "URL ";

	
}
