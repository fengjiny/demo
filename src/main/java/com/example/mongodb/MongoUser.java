package com.example.mongodb;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MongoUser {
    private String userId;

    private String name;

    private String age;

    private String password;

    private String phone;
}
