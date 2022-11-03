package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.PhoneSearch;
import org.apache.commons.lang3.tuple.Pair;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component(service = PhoneSearch.class)
@Designate(ocd = PhoneSearchImpl.Config.class)
public class PhoneSearchImpl implements PhoneSearch {

    private static final Logger log = LoggerFactory.getLogger(PhoneSearch.class);
    Map<String, String> map;

    @ObjectClassDefinition
    @interface Config {
        String[] countries() default {
        "+49-Germany",
        "+55-Austria",
        "+41-Switzerland"
        };
    }
    @Activate
    public void activate(Config config){
        this.map = Arrays.stream(config.countries())
                .map(e->e.split("-"))
                .map(e-> Pair.of(e[0], e[1]))
                .collect(Collectors.toMap(
                        Pair::getKey,
                        Pair::getValue
                ));

    }
    @Override
    public String phoneNumberToCountry(String number) {
        String num = number.split("-")[0];
        return map.getOrDefault(num, null);
    }
}

