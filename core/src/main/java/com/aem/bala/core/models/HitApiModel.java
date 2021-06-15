package com.aem.bala.core.models;




import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.aem.bala.core.services.HitApiService;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HitApiModel {
    @OSGiService
    HitApiService hitApiService;

    public List<String> getCountrynames() {
        return hitApiService.getCountryName();
    }
}
