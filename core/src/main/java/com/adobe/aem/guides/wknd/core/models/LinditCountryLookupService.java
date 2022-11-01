package com.adobe.aem.guides.wknd.core.models;


import java.util.Optional;

public interface LinditCountryLookupService {
    Optional<String> calculateCountry(String phoneNumber);
}
