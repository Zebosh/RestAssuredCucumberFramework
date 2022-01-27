package com.company.project.utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredUtil {

    public static Response sendGetRequest (String host, String path){

        return given().baseUri(host)
                .basePath(path).get().then().extract().response();
    }
}
