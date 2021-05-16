package com.aem.bala.core.models;

import java.io.BufferedReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;

import org.apache.commons.io.IOUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(name = "ResourceResolverItr", service = ResourceResolverItr.class, immediate = true)
public class ResourceResolverImpl implements ResourceResolverItr {

	private static final Logger LOG = LoggerFactory.getLogger(ResourceResolverImpl.class);

	@Reference
	ResourceResolverFactory resourceResolverFactory;

	ResourceResolver resourceResolver = null;

	private ResourceResolver getResourceResolver() {

		try {

			final String SERVICE_USER = "balasystem";

			Map<String, Object> paramMap = new HashMap<>();

			paramMap.put(ResourceResolverFactory.SUBSERVICE, SERVICE_USER);

			resourceResolver = resourceResolverFactory.getServiceResourceResolver(paramMap);

			LOG.info("Inside getResourceResolver");

		} catch (Exception e) {
			LOG.error("this is error" + e.getMessage());
		}

		return resourceResolver;

	}

	@Override
	public String getPageTitle() {

		ResourceResolver resourceResolver = getResourceResolver();

		Resource resource = resourceResolver.getResource("/content/secondProject/en");

		LOG.info(resource.getName());
		LOG.info("Inside page title");
		return resource.getName();
	}

	@Override
	public List<String> getPagePaths() {
		List<String> names = new ArrayList<String>();
		Resource resource = resourceResolver.getResource("/content/secondProject/en");
		Page page = resource.adaptTo(Page.class);
		// Node node =resource.adaptTo(Node.class);
		// PageManager pm = page.getPageManager();
		// Iterator<Node> nodes = node.listChildren();

		Iterator<Page> pages = page.listChildren();
		while (pages.hasNext()) {
			Page pageInfo = pages.next();
			String pagePath = pageInfo.getPath();
			names.add(pagePath);

		}
		return names;

		// resource.listChildren();

	}

	@Override
	public String getCsvFile() {
		// TODO Auto-generated method stub
		try {
			String assetData;
			Resource resource = resourceResolver.getResource("/content/dam/secondProject/English/CSVDemo.csv");
			Asset assetCsv = resource.adaptTo(Asset.class);
			Rendition rendition = assetCsv.getOriginal();
			InputStream br = rendition.adaptTo(InputStream.class);
			if (br != null) {
				assetData = IOUtils.toString(br, StandardCharsets.UTF_8);
				return assetData;
			} else {
				return "nothing";
			}

		} catch (Exception e) {
			LOG.error("exception occured");
		}

		return null;

	}

}
