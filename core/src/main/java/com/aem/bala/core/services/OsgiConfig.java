package com.aem.bala.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.aem.bala.core.config.ServiceConfig;

@Component(service = OsgiConfig.class, immediate = true)
@Designate(ocd = ServiceConfig.class) // ocd should be pointing to the interface of config
public class OsgiConfig {

	private String name;
	private int count;
	private boolean liveData;
	private String[] region;
	private String runMode;

	@Activate
	protected void activate(ServiceConfig serviceConfig) {
		name = serviceConfig.serviceName();
		count = serviceConfig.serviceCount();
		liveData = serviceConfig.serviceLiveData();
		region = serviceConfig.serviceRegion();
		runMode = serviceConfig.serviceRunMode();

	}

	public String getServiceName() {
		return name;

	}

	public int getServiceCount() {
		return count;
	}

	public boolean getServiceLiveData() {
		return liveData;
	}

	public String[] getServiceRegion() {
		return region;
	}

	public String getServiceRunMode() {
		return name;
	}

}
