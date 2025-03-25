package com.zebrunner.carina.api;

import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users/${userId}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/users/users/_put/rq.json")
@ResponseTemplatePath(path = "api/users/users/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateUserMethod extends BaseApiMethodV2 {
    public UpdateUserMethod(String userId) {
        super("api/users/users/_put/rq.json", "api/users/users/_put/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("userId", userId);
    }
}
