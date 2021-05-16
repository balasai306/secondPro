package com.aem.bala.core.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.bala.core.models.PageModel;
import com.aem.bala.core.services.CreatingPage;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;

@Component(service = CreatingPage.class, immediate = true)
public class CreatingPageimpl implements CreatingPage {
	private static final Logger Log = LoggerFactory.getLogger(CreatingPageimpl.class);
	@Reference
	ResourceResolverFactory resourceResolverFactory;

	ResourceResolver resourceResolver = null;

	@Activate
	@Modified
	public void activate() {

		try {
			final String SERVICE_USER = "balasystem";
			Map<String, Object> mapping = new HashMap();
			mapping.put(ResourceResolverFactory.SUBSERVICE, SERVICE_USER);

			resourceResolver = resourceResolverFactory.getServiceResourceResolver(mapping);
			Log.info("Inside getResourceResolver");
		} catch (LoginException e) {

			Log.info("Inside getResourceResolver failed" + e.getMessage());

		}

	}

	public List<PageModel> getCsvContent() throws IOException {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		List<PageModel> pageProperties = null;
		try {

			Resource resource = resourceResolver
					.getResource("/content/dam/secondProject/English/Documents/csvToPage.csv");
			Asset asset = resource.adaptTo(Asset.class);
			Rendition rendition = asset.getOriginal();
			is = rendition.adaptTo(InputStream.class);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			pageProperties = new LinkedList<PageModel>();

			pageProperties = br.lines().skip(1).map(singleLine -> {
				String[] arr = singleLine.split(",");
				PageModel pageModel = new PageModel();

				pageModel.setPageName(arr[0].trim());
				pageModel.setPageTemplate(arr[1].trim());
				pageModel.setPageTitle(arr[2].trim());
				pageModel.setPageParent(arr[3].trim());
				return pageModel;
			}).collect(Collectors.toList());

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (is != null) {
				is.close();
			}
		}
		return pageProperties;
	}

	@Override
	public int createPage() throws IOException {

		List<PageModel> pageProperties = getCsvContent();
		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		int pageCount = 0;
		try {
			for (PageModel i : pageProperties) {
				Page page = pageManager.create(i.getPageParent(), i.getPageName(), i.getPageTemplate(),
						i.getPageTitle());
				if (page != null) {
					pageCount++;
				}

			}
		} catch (WCMException e) {

			Log.info("page not created");
		}

		return pageCount;
	}

}
