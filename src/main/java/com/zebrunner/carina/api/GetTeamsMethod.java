package com.zebrunner.carina.api;

import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/teams", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/_teams/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetTeamsMethod extends BaseApiMethodV2 {
    public GetTeamsMethod() {
        super(null, "api/_teams/_get/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
