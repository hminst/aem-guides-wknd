package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.LinditCountryLookupService;
import org.apache.commons.lang3.tuple.Pair;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component(service = LinditCountryLookupService.class)
public class LinditCountryLookupServiceImpl implements LinditCountryLookupService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LinditCountryLookupServiceImpl.class);

    private Map<String, String> countries;


    @Override
    public String calculateCountry(String phoneNumber) {
        String countryCode = phoneNumber.split("-")[0];
        return countries.getOrDefault(countryCode, null);
    }

    @Activate
    protected void activate(Map<String, String[]> properties) {
        this.countries = Arrays.stream(properties.get("countries"))
                .map(entry -> entry.split(":"))
                .map(entry -> Pair.of(entry[0], entry[1]))
                .collect(Collectors.toMap(
                        Pair::getKey,
                        Pair::getValue,
                        (a, b) -> {
                            LOGGER.warn("Duplicate country code {} found", a);
                            return a;
                        }));
    }

}
