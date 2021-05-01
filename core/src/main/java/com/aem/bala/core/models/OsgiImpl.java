package com.aem.bala.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.aem.bala.core.services.OsgiConfig;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class OsgiImpl {

	@OSGiService
	OsgiConfig osgiConfig;

	public String serviceName() {
		return osgiConfig.getServiceName();

	}

	public int serviceCount() {
		return osgiConfig.getServiceCount();
	}

	public boolean serviceLiveData() {
		return osgiConfig.getServiceLiveData();
	}

	public String[] serviceRegion() {
		return osgiConfig.getServiceRegion();
	}

	public String serviceRunMode() {
		return osgiConfig.getServiceRunMode();
	}

}
