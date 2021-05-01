package com.aem.bala.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
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

//adaptables = Resource.class
@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Sample {

	private static final Logger LOG = LoggerFactory.getLogger(Sample.class);

	@SlingObject
	ResourceResolver resourceResolver;

	@Self // object it self into model
	SlingHttpServletRequest slingHttpServletRequest;

	@RequestAttribute(name = "rAttri")
	private String reqAttri;

	@ScriptVariable
	Page currentPage;

	@Inject
	@Via("resource")
	String name;

	// we can use @Inject or @ValueMapValue

	@ValueMapValue
	int age;

	@Inject
	@Via("resource")
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

	public String getPageTitle() {

		return currentPage.getTitle();
	}

	public String getRequestAttribute() {

		return reqAttri;
	}
//	@OSGiService
//	QueryBuilder queryBuilder;
	// @Postconstruct,@Named("name property of the element ")

}
