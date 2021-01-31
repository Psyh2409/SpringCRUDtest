package com.gmail.psyh2409.services;

import com.gmail.psyh2409.dto.UsersDTO;
import com.gmail.psyh2409.exeptions.ValidationException;

import java.util.List;

public interface UsersService {

    UsersDTO saveUser(UsersDTO usersDTO) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDTO findByLogin(String login);

    List<UsersDTO> findAll();
}
