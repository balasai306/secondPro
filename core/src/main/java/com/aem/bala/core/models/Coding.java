package com.aem.bala.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Coding {

	@ValueMapValue
	String name;

	@Inject
	@Via("resource")
	boolean check;

	@ValueMapValue
	String myselect;

	@Inject
	@Via("resource")
	String path;

	@ValueMapValue
	private List<String> fieldItem;

	public String getName() {
		return name;
	}

	public boolean getCheck() {
		return check;
	}

	public String getSelect() {
		return myselect;
	}

	public String getPath() {
		return path;
	}

	public List<String> getListItems() {
		if (fieldItem != null) {
			return new ArrayList<String>(fieldItem);
		} else {
			return Collections.emptyList();
		}

	}
}
