package com.zebrunner.carina.myApi;

import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/projects/{projectId}/archive", methodType = HttpMethodType.POST)
@ResponseTemplatePath(path = "api/projects/projects/_archive/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class ArchiveProjectMethod extends BaseApiMethodV2 {
    public ArchiveProjectMethod(String projectId) {
        super(null, "api/projects/projects/_archive/rs.json");

        // Вывести в лог переданные параметры
        System.out.println("Base URL: " + Configuration.getRequired("api_url"));
        System.out.println("Project ID: " + projectId);

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("projectId", projectId);
    }
}
