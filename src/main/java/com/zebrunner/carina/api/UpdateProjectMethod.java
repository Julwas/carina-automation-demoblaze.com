package com.zebrunner.carina.api;

import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/projects/${projectId}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/projects/projects/_put/rq.json")
@ResponseTemplatePath(path = "api/projects/projects/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateProjectMethod extends BaseApiMethodV2 {
    public UpdateProjectMethod(String projectId) {
        super("api/projects/projects/_put/rq.json", "api/projects/projects/_put/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("projectId", projectId);
    }
}
