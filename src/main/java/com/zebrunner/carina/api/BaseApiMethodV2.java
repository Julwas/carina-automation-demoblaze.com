package com.zebrunner.carina.api;

import com.zebrunner.carina.utils.config.Configuration;

public class BaseApiMethodV2 extends AbstractApiMethodV2 {

    public BaseApiMethodV2(String rqPath, String rsPath) {
        super(rqPath, rsPath, "config.properties");
        String token = Configuration.getRequired("api_token");
        super.setHeader("Authorization", "Bearer " + token);
        super.setHeader("Content-Type", "application/json");
    }
}
