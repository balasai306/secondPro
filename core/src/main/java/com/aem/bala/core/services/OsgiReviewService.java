package com.aem.bala.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.bala.core.config.OsgiReview;
import com.aem.bala.core.servlets.SiteMapGeneratorServlet;

@Component(service = OsgiReviewService.class, immediate = true)
@Designate(ocd = OsgiReview.class)
public class OsgiReviewService {
	private String name;
	private boolean checkBox;
	private String[] multiField;
	private String option;
	private static Logger LOG = LoggerFactory.getLogger(OsgiReviewService.class);

	@Activate
	protected void activate(OsgiReview osgiReview) {
		name = osgiReview.osgiName();
		checkBox = osgiReview.osgiCheckBox();
		multiField = osgiReview.osgiMultiField();
		option = osgiReview.osgiOptions();
	

	}

	public String getOsgiName() {
		// TODO Auto-generated method stub

		return name;
	}

	public boolean getOsgiCheckBox() {
		// TODO Auto-generated method stub
		return checkBox;
	}

	public String[] getOsgiMultiField() {
		// TODO Auto-generated method stub
		return multiField;
	}

	public String getOsgiOptions() {
		// TODO Auto-generated method stub
		return option;
	}

}
