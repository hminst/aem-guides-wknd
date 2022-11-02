package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.NihadCountryLookupService;
import org.osgi.service.component.annotations.Component;

@Component(
        service = {NihadCountryLookupService.class}
)
public class NihadCountryLookupServiceImpl implements NihadCountryLookupService {
    @Override
    public String getCountryName(String phoneNumber) {
        if (phoneNumber.startsWith("+49")) {
            return phoneNumber + " (Germany)";
        } else if (phoneNumber.startsWith("+41")) {
            return phoneNumber + " (Switzerland)";
        }
        return phoneNumber;
    }
}
