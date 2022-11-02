package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.PhoneSearch;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service ={PhoneSearch.class}
)
public class VanjaPhoneSearchImpl implements PhoneSearch {

  private static  final Logger log = LoggerFactory.getLogger(PhoneSearch.class);
  private Map<String,String> countries;

  @Activate
  protected void activate(Map<String, String> properties) {
    this.countries = properties;
  }
  @Override
  public Optional<String> getTheCountry(String phoneNumber) {
    String countryCode = phoneNumber.split("-")[0];
    return Optional.ofNullable(countries.getOrDefault(countryCode, null));
  }

}
