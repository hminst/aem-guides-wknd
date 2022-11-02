package com.adobe.aem.guides.wknd.core.models;

import java.util.Optional;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface PhoneSearch {

    Optional<String> getTheCountry(String phoneNumber);

}
