package com.zebrunner.carina.api;

import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/users/users/_post/rq.json")
@ResponseTemplatePath(path = "api/users/users/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class CreateUserMethod extends BaseApiMethodV2 {
    public CreateUserMethod() {
        super("api/users/users/_post/rq.json", "api/users/users/_post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
}}