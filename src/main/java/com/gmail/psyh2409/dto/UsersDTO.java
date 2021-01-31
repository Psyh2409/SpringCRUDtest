package com.gmail.psyh2409.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsersDTO {

    private Integer id;
    private String name;
    private String login;
    private String email;
}
