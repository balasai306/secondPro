package com.aem.bala.core.services;

import java.io.Writer;

import org.apache.sling.api.resource.Resource;

public interface SiteMapGenerator {
	
void generateSiteMap(Resource siteResource,Writer writer);
}
