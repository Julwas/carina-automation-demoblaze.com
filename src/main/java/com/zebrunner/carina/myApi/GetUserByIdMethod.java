package com.zebrunner.carina.myApi;

import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users/${userId}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/users/_get_one/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUserByIdMethod extends BaseApiMethodV2 {
    public GetUserByIdMethod(String userId) {
        super(null, "api/users/users/_get_one/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("userId", Configuration.getRequired("userId"));
    }
}
