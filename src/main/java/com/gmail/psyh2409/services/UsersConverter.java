package com.gmail.psyh2409.services;

import com.gmail.psyh2409.dto.UsersDTO;
import com.gmail.psyh2409.entities.Users;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class UsersConverter {

    public Users fromUserDTOToUser(UsersDTO usersDTO) {
        return isNull(usersDTO) ? null : Users.builder()
                .id(usersDTO.getId())
                .name(usersDTO.getName())
                .login(usersDTO.getLogin())
                .email(usersDTO.getEmail())
                .build();
    }

    public UsersDTO fromUserToUserDTO(Users users) {
        return isNull(users) ? null : UsersDTO.builder()
                .id(users.getId())
                .name(users.getName())
                .login(users.getLogin())
                .email(users.getEmail())
                .build();
    }
}
