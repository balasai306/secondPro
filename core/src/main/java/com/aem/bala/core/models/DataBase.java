package com.aem.bala.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.day.commons.datasource.jdbcpool.JdbcPoolService;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DataBase {

	@OSGiService
	JdbcPoolService jdbcPoolService;

	public String getDriver() {
		return jdbcPoolService.OSGI_PROPERTY_JDBC_DRIVER_CLASS;

	}

	public String getName() {
		return jdbcPoolService.OSGI_PROPERTY_JDBC_USERNAME;
	}

	public String getPassword() {
		return jdbcPoolService.OSGI_PROPERTY_JDBC_PASSWORD;

	}
}
