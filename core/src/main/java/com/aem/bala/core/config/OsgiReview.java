package com.aem.bala.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
//Create configurations with 4 types : Boolean , string , multifield and options , 
//get the values into sling model and print on slightly page.
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "osgi review", description = "osgiconfig for review")
public @interface OsgiReview {
	@AttributeDefinition(name = "OsgiName", 
			description = "name for osgi review", 
			type = AttributeType.STRING)
	public String osgiName();
	
	@AttributeDefinition(name = "OsgiCheckBox", 
			description = "CheckBoxfor osgi review", 
			type = AttributeType.BOOLEAN)
	public boolean osgiCheckBox();
	
	@AttributeDefinition(name = "OsgiMultiField", 
			description = "CheckBoxfor osgi review", 
			type = AttributeType.STRING)
	public String[] osgiMultiField();
	
	@AttributeDefinition(name = "OsgiOptions", 
			description = "CheckBoxfor osgi review", 
			type = AttributeType.STRING,options= {
					@Option(label="op1",value = "op1"),
					@Option(label="op2",value = "op2"),
					@Option(label="op3",value = "op3"),
			})
	public String osgiOptions();
}
