package com.adobe.aem.guides.wknd.core.services;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface MarijaCountryLookupService {
  String getCountryCodeLookup(String phoneNumber);
}
