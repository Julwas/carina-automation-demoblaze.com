package com.zebrunner.carina.myApi;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;

import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
@Endpoint(url = "${base_url}/projects", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/projects/_post/rq.json")
@ResponseTemplatePath(path = "api/projects/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class CreateProjectMethod extends BaseApiMethodV2 {
    public CreateProjectMethod() {
        super("api/projects/_post/rq.json", "api/projects/_post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
