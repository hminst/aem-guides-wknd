package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.PhoneSearch;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component(service = {PhoneSearch.class})
@Designate(ocd = PhoneSearchImpl.Config.class)
public class PhoneSearchImpl implements PhoneSearch {

    private static final Logger log = (Logger) LoggerFactory.getLogger(PhoneSearch.class);
    Map<String, String> map = new HashMap<>();

    @ObjectClassDefinition
    @interface Config {
        String[] getCountries() default {
        "+49:Germany",
        "+55:Austria",
        "+41:Switzerland"
        };
    }

    @Activate
    public void activate(Config config){

    }

    @Override
    public String phoneNumberToCountry(String number) {

        String num = number.substring(0, 3);

        if (map.containsKey(num)){
            return number + " " + map.values();
        }
        return null;
    }
}

