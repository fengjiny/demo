package com.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName="test",type="user",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class User {
    @Id
    private Integer id;

//    private String userId;

    private String name;

//    private String age;

    private String password;

    private String phone;
}