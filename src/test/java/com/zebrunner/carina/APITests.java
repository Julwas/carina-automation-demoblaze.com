package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.myApi.PostCreateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITests implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Test()
    public void testCreateUser() {
        LOGGER.info("test");
        PostCreateUser postCreateUser = new PostCreateUser();
        postCreateUser.callAPIExpectSuccess();
        postCreateUser.validateResponseAgainstSchema("api/users/_post/signup_response.json");
        /*try {
        postCreateUser.validateResponseAgainstSchema("api/users/_post/signup_response.json");
        } catch (Exception e) {
            System.out.println("⚠️ Validation error, but the test continues: " + e.getMessage());
        }*/
    }

    /*@Test()
    public void testLogIn() {
        PostLogInMethod postLogInMethod = new PostLogInMethod();
        postLogInMethod.callAPIExpectSuccess();
        postLogInMethod.validateResponseAgainstSchema("api/users/_post/logIn_rs.json");
        /*try {
            postLogInMethod.validateResponseAgainstSchema("api/users/_post/logIn_rs.json");
        } catch (Exception e) {
            System.out.println("⚠️ Validation error, but the test continues: " + e.getMessage());
        }*/
    }






