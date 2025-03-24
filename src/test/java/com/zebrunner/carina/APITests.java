package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.myApi.*;
import com.zebrunner.carina.utils.config.Configuration;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class APITests implements IAbstractTest {
    @Test
    public void testGetProjects() {
        GetProjectsMethod getProjectsMethod = new GetProjectsMethod();
        getProjectsMethod.callAPIExpectSuccess();
        getProjectsMethod.validateResponse(JSONCompareMode.LENIENT);
    }
    @Test
    public void testCreateProject() {
        CreateProjectMethod createProjectMethod = new CreateProjectMethod();
        Response response = createProjectMethod.callAPIExpectSuccess();
        response.then()
                .body("data.name", equalTo("proj3"))
                .body("data.description", equalTo("some description"))
                .body("data.key", equalTo("proj3"));
    }
    @Test
    public void testGetProjectById() {
        String projectId = Configuration.getRequired("project_id");
        ;
        GetProjectByIdMethod getProjectByIdMethod = new GetProjectByIdMethod(projectId);
        getProjectByIdMethod.callAPIExpectSuccess();
        getProjectByIdMethod.validateResponse();
    }
    @Test
    public void testUpdateProject() {
        String projectId = Configuration.getRequired("project_id");
        UpdateProjectMethod updateProjectMethod = new UpdateProjectMethod(projectId);
        updateProjectMethod.callAPIExpectSuccess();
        updateProjectMethod.validateResponse(JSONCompareMode.LENIENT);
    }
    @Test
    public void testGetUsers() {
        GetUsersMethod getUsersMethod = new GetUsersMethod();
        getUsersMethod.callAPIExpectSuccess();
        getUsersMethod.validateResponse(JSONCompareMode.LENIENT);
    }
    @Test
    public void testCreateUser() {

        CreateUserMethod createUserMethod = new CreateUserMethod();

        Response response = createUserMethod.callAPIExpectSuccess();
        response.then()
                .body("data.first_name", equalTo("Anela"))
                .body("data.last_name", equalTo("Goodie"))
                .body("data.email", equalTo("Goodie@testmonitor.com"));
    }

    @Test
    public void testGetUserById() {
        String userId = Configuration.getRequired("userId");
        ;
        GetUserByIdMethod getUserByIdMethod = new GetUserByIdMethod(userId);
        getUserByIdMethod.callAPIExpectSuccess();
        getUserByIdMethod.validateResponse();
    }

    @Test
    public void testUpdateUser() {
        String userId = Configuration.getRequired("userId");
        UpdateUserMethod updateUserMethod = new UpdateUserMethod(userId);
        updateUserMethod.callAPIExpectSuccess();
        updateUserMethod.validateResponse(JSONCompareMode.LENIENT);
    }

    @Test
    public void testDeleteUser() {
        String userId = Configuration.getRequired("userId");
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(userId);
        Response deleteResponse = deleteUserMethod.callAPIExpectSuccess();
        System.out.println("Actual response code: " + deleteResponse.getStatusCode());
        System.out.println("Response Body: " + deleteResponse.asString());
        Assert.assertEquals(deleteResponse.getStatusCode(), 204,
                "Error: The response code for deleting a user is incorrect!");
    }

    @Test
    public void testGetTeamById() {
        String userId = Configuration.getRequired("teamId");
        GetTeamByIdMethod getTeamByIdMethod = new GetTeamByIdMethod(userId);
        getTeamByIdMethod.callAPIExpectSuccess();
        getTeamByIdMethod.validateResponse();
    }
    @Test
    public void testGetTeams() {
        GetTeamsMethod getTeamsMethod = new GetTeamsMethod();
        getTeamsMethod.callAPIExpectSuccess();
        getTeamsMethod.validateResponse(JSONCompareMode.LENIENT);
    }
}






