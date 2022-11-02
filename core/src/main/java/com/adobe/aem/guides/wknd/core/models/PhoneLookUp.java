package com.adobe.aem.guides.wknd.core.models;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface PhoneLookUp {

  String getCountryByPhone(String phoneNumber);
}
