package com.register.controller.param;

public interface EndPointPath {


    interface UserResourcePath {

        String USER = "/user";
        String ID = "/{id}";
    }

    interface CountryResourcePath {

        String COUNTRY = "/country";
    }
}