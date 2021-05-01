package com.aem.bala.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Books {
	private static final Logger LOG = LoggerFactory.getLogger(Sample.class);

	@SlingObject
	SlingHttpServletRequest slingHttpServletRequest;

	@ValueMapValue
	private String name;

	@ValueMapValue
	private List<String> books;

	public String getName() {
		return name;

	}

	public List<String> getBooks() {
		if (books != null) {
			return books;
		} else {
			return Collections.emptyList();
		}
	}

	public List<Map<String, String>> getBookDetails() {
		List<Map<String, String>> bookDetailsMap = new ArrayList<Map<String, String>>();
		try {
//            Resource bookdetails1 = componentResource.getChild("bookdetails");
			Resource bookdetails = slingHttpServletRequest.getResource().getChild("booksDetails");
			if (bookdetails != null) {
				for (Resource i : bookdetails.getChildren()) {
					Map<String, String> bookmap = new HashMap<String, String>();
					bookmap.put("bookName", i.getValueMap().get("bookName", String.class));
					bookmap.put("bookYear", i.getValueMap().get("bookYear", String.class));
					bookDetailsMap.add(bookmap);
				}
			}
		} catch (Exception e) {
			LOG.info("\n Error While Getting book11" + bookDetailsMap.size() + " details", e.getMessage());
		}
		return bookDetailsMap;
	}

}
