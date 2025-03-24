package com.zebrunner.carina.myApi;

import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/teams/${teamId}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/_teams/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetTeamByIdMethod extends BaseApiMethodV2 {
    public GetTeamByIdMethod(String project_Id) {
        super(null, "api/_teams/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("teamId", Configuration.getRequired("teamId"));
    }
}
