package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.MarijaCountryLookupService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service = { MarijaCountryLookupService.class }
)
@Designate(ocd = MarijaCountryLookupServiceImpl.Config.class)
public class MarijaCountryLookupServiceImpl implements MarijaCountryLookupService{

  private static final Logger log = LoggerFactory.getLogger(MarijaCountryLookupServiceImpl.class);

  @ObjectClassDefinition(
      name = "Country Lookup Service",
      description = "OSGi Service providing information about phone number"
  )
  @interface Config {

    @AttributeDefinition(
        name = "Phone numbers and countries"
    )
    String[] countryCode() default { "+41&Switzerland", "+49&Germany", "+389&North Macedonia" };

  }


  private String[] countryCode;


  @Override
  public String getCountryCodeLookup(String phoneNumber) {
    HashMap<String, String> countryNumber=new HashMap<>();
    Arrays.stream(countryCode).forEach(cc->
    {
      List<String> list= Arrays.asList(cc.split("&"));
      countryNumber.put(list.get(0),list.get(1));
    });
    List<String> phoneNumberList= Arrays.asList(phoneNumber.split("-"));

    return countryNumber.entrySet().stream().filter( e -> e.getKey().contains( phoneNumberList.get(0))).findFirst().get().getValue();
  }

  @Activate
  protected void activate(Config config) {

    this.countryCode = config.countryCode();

    log.info("Activated Country Lookup Impl with countries [ {} ]", String.join(", ", this.countryCode));
  }

  @Deactivate
  protected void deactivate() {
    log.info("Country Lookup has been deactivated!");
  }

}