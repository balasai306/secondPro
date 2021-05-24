package com.aem.bala.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AemCodingChallenge {
	private static final Logger LOG = LoggerFactory.getLogger(AemCodingChallenge.class);

	@Inject
	String bookcategory;

	@Inject
	boolean check;

	@Inject
	String select;

	@Inject
	private List<String> books;

	public String getBookCategory() {
		LOG.info(bookcategory);
		return bookcategory;
	}

	public boolean getCheck() {
		if (check == true) {
			LOG.info("true");
		} else {
			LOG.info("false");
		}

		return check;
	}

	public String getSelect() {
		LOG.info(select);
		return select;
	}

	public List<String> getBookTitles() {

		if (books != null) {
			
			return new ArrayList<String>(books);

		} else {
			return Collections.emptyList();
		}

	}

}
