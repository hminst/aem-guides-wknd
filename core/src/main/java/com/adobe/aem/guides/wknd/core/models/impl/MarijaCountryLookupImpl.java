package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.MarijaCountryLookup;
import com.adobe.aem.guides.wknd.core.services.MarijaCountryLookupService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    resourceType = {
        MarijaCountryLookupImpl.RESOURCE_TYPE},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MarijaCountryLookupImpl implements MarijaCountryLookup {
  protected static final String RESOURCE_TYPE = "wknd/components/marijaCountryLookup";
  protected final MarijaCountryLookupService lookupService;

  @ValueMapValue
  private String phoneNumber;

  public MarijaCountryLookupImpl(MarijaCountryLookupService lookupService) {
    this.lookupService = lookupService;
  }


  @Override
  public String getCountryCodeLookup(String phoneNumber) {
    return lookupService.getCountryCodeLookup(phoneNumber);
  }
}
