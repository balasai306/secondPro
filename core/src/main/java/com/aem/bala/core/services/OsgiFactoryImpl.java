package com.aem.bala.core.services;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.bala.core.config.OsgiFactoryConfig;

@Component(service = OsgiFactoryImpl.class, immediate = true)
@Designate(ocd = OsgiFactoryConfig.class,factory = true) // ocd should be pointing to the interface of config

public class OsgiFactoryImpl {
	private static final Logger log = LoggerFactory.getLogger(OsgiFactoryImpl.class);

	private int configId;
	private String serviceName;
	private String serviceUrl;
	private List<OsgiFactoryConfig> configList;

	@Activate
	@Modified
	protected void activate(OsgiFactoryConfig fac) {

		configId = fac.configId();
		serviceName = fac.serviceName();
		serviceUrl = fac.serviceUrl();

	}

	@Reference(service = OsgiFactoryConfig.class, cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)

	public void bindOsgiFactoryConfig(OsgiFactoryConfig config) {
		if (configList == null) {
			configList = new ArrayList<>();

		}
		configList.add(config);

	}

	public void unbindOsgiFactoryConfig(OsgiFactoryConfig config) {

		configList.remove(config);

	}

	public int getConfigId() {
		return configId;
	}

	public String getServiceName() {
		return serviceName;

	}

	public String getServiceUrl() {
		return serviceUrl;

	}

	public List<OsgiFactoryConfig> getConfigList() {
		return configList;

	}

}
