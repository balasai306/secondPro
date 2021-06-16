package com.aem.bala.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ListFooter {

	private static final Logger LOG = LoggerFactory.getLogger(ListFooter.class);

	@Self
	SlingHttpServletRequest componentResource;

	@ValueMapValue
	private String companytitle;

	@ValueMapValue
	private String myaccounttitle;

	@ValueMapValue
	private String supporttitle;

	@ValueMapValue
	private String findbooktitle;

	public String getCompanytitle() {
		return companytitle;
	}

	public String getMyaccounttitle() {
		return myaccounttitle;
	}

	public String getSupporttitle() {
		return supporttitle;
	}

	public String getFindbooktitle() {
		return findbooktitle;
	}

	public List<Map<String, String>> getCompanyDetails() {
		List<Map<String, String>> companyDetailsMap = new ArrayList<Map<String, String>>();
		try {
			Resource companydetails1 = componentResource.getResource().getChild("company");
			if (companydetails1 != null) {
				for (Resource i : companydetails1.getChildren()) {
					Map<String, String> companymap = new HashMap<String, String>();
					companymap.put("companyname", i.getValueMap().get("companyname", String.class));
					companymap.put("companyurl", i.getValueMap().get("companyurl", String.class));
					companyDetailsMap.add(companymap);
				}
			}
		} catch (Exception e) {
			LOG.info("\n Error While Getting book11" + companyDetailsMap.size() + " details", e.getMessage());
		}
		return companyDetailsMap;
	}

	public List<Map<String, String>> getMyaccount() {
		List<Map<String, String>> myaccountDetailsMap = new ArrayList<Map<String, String>>();
		try {
			Resource myaccountdetails1 = componentResource.getResource().getChild("myaccount");
			if (myaccountdetails1 != null) {
				for (Resource i : myaccountdetails1.getChildren()) {
					Map<String, String> myaccountmap = new HashMap<String, String>();
					myaccountmap.put("myaccountname", i.getValueMap().get("myaccountname", String.class));
					myaccountmap.put("myaccounturl", i.getValueMap().get("myaccounturl", String.class));
					myaccountDetailsMap.add(myaccountmap);
				}
			}
		} catch (Exception e) {
			LOG.info("\n Error While Getting book11" + myaccountDetailsMap.size() + " details", e.getMessage());
		}
		return myaccountDetailsMap;
	}

	public List<Map<String, String>> getSupport() {
		List<Map<String, String>> supportDetailsMap = new ArrayList<Map<String, String>>();
		try {
			Resource supportdetails1 = componentResource.getResource().getChild("support");
			if (supportdetails1 != null) {
				for (Resource i : supportdetails1.getChildren()) {
					Map<String, String> supportmap = new HashMap<String, String>();
					supportmap.put("supportname", i.getValueMap().get("supportname", String.class));
					supportmap.put("supporturl", i.getValueMap().get("supporturl", String.class));
					supportDetailsMap.add(supportmap);
				}
			}
		} catch (Exception e) {
			LOG.info("\n Error While Getting book11" + supportDetailsMap.size() + " details", e.getMessage());
		}
		return supportDetailsMap;
	}

	public List<Map<String, String>> getFindbook() {
		List<Map<String, String>> findbookDetailsMap = new ArrayList<Map<String, String>>();
		try {
			Resource findbookdetails1 = componentResource.getResource().getChild("findbook");
			if (findbookdetails1 != null) {
				for (Resource i : findbookdetails1.getChildren()) {
					Map<String, String> findbookmap = new HashMap<String, String>();
					findbookmap.put("findbookname", i.getValueMap().get("findbookname", String.class));
					findbookmap.put("findbookurl", i.getValueMap().get("findbookurl", String.class));
					findbookDetailsMap.add(findbookmap);
				}
			}
		} catch (Exception e) {
			LOG.info("\n Error While Getting book11" + findbookDetailsMap.size() + " details", e.getMessage());
		}
		return findbookDetailsMap;
	}
}
