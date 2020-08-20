package com.example.api.webapi.entity.userServer;

import lombok.Data;

@Data
public class BaseEntity {
    private Integer start;
    private Integer rows;
    private String sort;

}
