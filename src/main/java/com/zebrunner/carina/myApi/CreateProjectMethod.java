package com.zebrunner.carina.myApi;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;

import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

@Endpoint(url = "${base_url}/projects", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/projects/projects/_post/rq.json")
@ResponseTemplatePath(path = "api/projects/projects/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class CreateProjectMethod extends BaseApiMethodV2 {
    public CreateProjectMethod() {
        super("api/projects/projects/_post/rq.json", "api/projects/projects/_post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
    public void validateCustomResponse() {
        String actualResponse = callAPI().asString();

        String expectedJson = "{"
                + "\"data\": {"
                + "    \"id\": \"*\","
                + "    \"key\": \"*\","
                + "    \"created_at\": \"*\","
                + "    \"updated_at\": \"*\","
                + "    \"endpoints\": {"
                + "        \"activities\": \"https://juli12.testmonitor.com/api/v1/project/*/activities\","
                + "        \"archive\": \"https://juli12.testmonitor.com/api/v1/project/*/archive\","
                + "        \"members\": \"https://juli12.testmonitor.com/api/v1/project/*/members\","
                + "        \"non-members\": \"https://juli12.testmonitor.com/api/v1/project/*/non-members\","
                + "        \"show\": \"https://juli12.testmonitor.com/api/v1/projects/*\","
                + "        \"unarchive\": \"https://juli12.testmonitor.com/api/v1/project/*/restore\","
                + "        \"update\": \"https://juli12.testmonitor.com/api/v1/projects/*\""
                + "    },"
                + "    \"links\": {"
                + "        \"integrations\": \"https://juli12.testmonitor.com/settings/integrations/*\","
                + "        \"select\": \"https://juli12.testmonitor.com/setup/select-project/*\","
                + "        \"show\": \"https://juli12.testmonitor.com/settings/projects/*\""
                + "    }"
                + "}"
                + "}";

        System.out.println("Actual Response: " + actualResponse); // Логируем ответ для отладки

        try {
            JSONAssert.assertEquals(expectedJson, actualResponse,
                    new CustomComparator(JSONCompareMode.LENIENT,
                            new Customization("data.id", (o1, o2) -> true),
                            new Customization("data.key", (o1, o2) -> true),
                            new Customization("data.created_at", (o1, o2) -> true),
                            new Customization("data.updated_at", (o1, o2) -> true),
                            new Customization("data.endpoints.activities", (o1, o2) -> true),
                            new Customization("data.endpoints.archive", (o1, o2) -> true),
                            new Customization("data.endpoints.members", (o1, o2) -> true),
                            new Customization("data.endpoints.non-members", (o1, o2) -> true),
                            new Customization("data.endpoints.show", (o1, o2) -> true),
                            new Customization("data.endpoints.unarchive", (o1, o2) -> true),
                            new Customization("data.endpoints.update", (o1, o2) -> true),
                            new Customization("data.links.integrations", (o1, o2) -> true),
                            new Customization("data.links.select", (o1, o2) -> true),
                            new Customization("data.links.show", (o1, o2) -> true)
                    ));

        } catch (AssertionError e) {
            throw new AssertionError("JSON response validation failed:\n" + e.getMessage());
        }
}}
