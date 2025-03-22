package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.myApi.PostCreateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITests implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Test
    public void testGetUsers() {
        AbstractApiMethodV2 getUsers = new AbstractApiMethodV2(null, "api/users/_get/rs.json");
        getUsers.setHeaders("Content-Type=application/json");
        getUsers.callAPIExpectSuccess();
        getUsers.validateResponse();
    }

    @Test
    public void testGetSingleUser() {
        AbstractApiMethodV2 getUser = new AbstractApiMethodV2(null, "api/users/2/_get/rs.json");
        getUser.setHeaders("Content-Type=application/json");
        getUser.callAPIExpectSuccess();
        getUser.validateResponse();
    }

    @Test
    public void testCreateUser() {
        AbstractApiMethodV2 createUser = new AbstractApiMethodV2("api/users/_post/rq.json", "api/users/_post/rs.json");
        createUser.setHeaders("Content-Type=application/json");
        createUser.callAPIExpectSuccess();
        createUser.validateResponse();
    }

    @Test
    public void testUpdateUser() {
        AbstractApiMethodV2 updateUser = new AbstractApiMethodV2("api/users/2/_put/rq.json", "api/users/2/_put/rs.json");
        updateUser.setHeaders("Content-Type=application/json");
        updateUser.callAPIExpectSuccess();
        updateUser.validateResponse();
    }

    @Test
    public void testPatchUser() {
        AbstractApiMethodV2 patchUser = new AbstractApiMethodV2("api/users/2/_patch/rq.json", "api/users/2/_patch/rs.json");
        patchUser.setHeaders("Content-Type=application/json");
        patchUser.callAPIExpectSuccess();
        patchUser.validateResponse();
    }

    @Test
    public void testDeleteUser() {
        AbstractApiMethodV2 deleteUser = new AbstractApiMethodV2(null, "api/users/2/_delete/rs.json");
        deleteUser.setHeaders("Content-Type=application/json");
        deleteUser.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteUser.callAPI();
    }

    @Test
    public void testGetUnknown() {
        AbstractApiMethodV2 getUnknown = new AbstractApiMethodV2(null, "api/unknown/_get/rs.json");
        getUnknown.setHeaders("Content-Type=application/json");
        getUnknown.callAPIExpectSuccess();
        getUnknown.validateResponse();
    }

    @Test
    public void testGetSingleResource() {
        AbstractApiMethodV2 getResource = new AbstractApiMethodV2(null, "api/unknown/2/_get/rs.json");
        getResource.setHeaders("Content-Type=application/json");
        getResource.callAPIExpectSuccess();
        getResource.validateResponse();
    }

    @Test
    public void testRegisterUser() {
        AbstractApiMethodV2 registerUser = new AbstractApiMethodV2("api/register/_post/rq.json", "api/register/_post/rs.json");
        registerUser.setHeaders("Content-Type=application/json");
        registerUser.callAPIExpectSuccess();
        registerUser.validateResponse();
    }

    @Test
    public void testLoginUser() {
        AbstractApiMethodV2 loginUser = new AbstractApiMethodV2("api/login/_post/rq.json", "api/login/_post/rs.json");
        loginUser.setHeaders("Content-Type=application/json");
        loginUser.callAPIExpectSuccess();
        loginUser.validateResponse();
    }
    }






