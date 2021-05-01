package com.aem.bala.core.models;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.aem.bala.core.config.OsgiFactoryConfig;
import com.aem.bala.core.services.OsgiFactoryImpl;

@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy =DefaultInjectionStrategy.OPTIONAL)
public class OsgiFactoryModel {

	@OSGiService
	OsgiFactoryImpl osgiFactoryImpl;
	
	
	public List<OsgiFactoryConfig> getConfigList(){
		return osgiFactoryImpl.getConfigList();
		
	}
}
