package com.zebrunner.carina;

import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.myApi.CreateProjectMethod;
import com.zebrunner.carina.myApi.GetProjectsMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;

import org.testng.annotations.Test;


public class APITests implements IAbstractTest {
   /* @Test
    public void testGetProjects() {
        GetProjectsMethod getProjectsMethod = new GetProjectsMethod();
        getProjectsMethod.callAPIExpectSuccess();
        getProjectsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }*/

    @Test
    public void testCreateProject() {
        CreateProjectMethod createProjectMethod = new CreateProjectMethod();
        createProjectMethod.callAPIExpectSuccess();
        createProjectMethod.validateResponse();
    }
    }






