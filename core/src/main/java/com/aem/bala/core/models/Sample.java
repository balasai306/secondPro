package com.aem.bala.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
//adaptables = SlingHttpServletRequest.class
//
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Sample {

	


	@Inject
	
	String name;

	// we can use @Inject or @ValueMapValue

	@Inject
	int age;

	@Inject

	boolean check;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean getCheck() {

		return check;
	}


//	@OSGiService
//	QueryBuilder queryBuilder;
	// @Postconstruct,@Named("name property of the element ")

}
