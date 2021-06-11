package com.aem.bala.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.aem.bala.core.services.OsgiReviewService;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OsgiReviewModel {
	@OSGiService
	OsgiReviewService osgiReviewService;

	public String getOsgiName() {
		return osgiReviewService.getOsgiName();

	}

	public boolean getOsgiCheckBox() {
		return osgiReviewService.getOsgiCheckBox();

	}

	public String[] getOsgiMultiField() {
		return osgiReviewService.getOsgiMultiField();

	}

	public String getOsgiOptions() {
		return osgiReviewService.getOsgiOptions();

	}

}
