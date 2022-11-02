package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.LinditCountryLookupService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

@Component(service = LinditCountryLookupService.class)
public class LinditCountryLookupServiceImpl implements LinditCountryLookupService {
    private Map<String, String> countries;


    @Override
    public String calculateCountry(String phoneNumber) {
        String countryCode = phoneNumber.split("-")[0];
        return countries.getOrDefault(countryCode, null);
    }

    @Activate
    protected void activate(Map<String, String> properties) {
        this.countries = properties;
    }

}
