package com.zebrunner.carina.myApi;

import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/projects/${project_id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/projects/projects/_get_one/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetProjectByIdMethod extends BaseApiMethodV2 {
    public GetProjectByIdMethod(String project_Id) {
        super(null, "api/projects/projects/_get_one/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("project_id", Configuration.getRequired("project_id"));
    }
}
