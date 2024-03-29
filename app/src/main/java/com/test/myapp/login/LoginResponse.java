package com.test.myapp.login;


import java.util.HashMap;
import java.util.Map;


public class LoginResponse {


    private Boolean success;

    private String token;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Boolean getSuccess() {
        return success;
    }


    public void setSuccess(Boolean success) {
        this.success = success;
    }


    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
