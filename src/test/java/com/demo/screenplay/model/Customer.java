package com.demo.screenplay.model;

import lombok.Getter;

@Getter
public enum Customer {

    Mark("standard_user", "secret_sauce"),
    Mary("locked_out_user", "secret_sauce");

    private String username;
    private String password;

    Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
