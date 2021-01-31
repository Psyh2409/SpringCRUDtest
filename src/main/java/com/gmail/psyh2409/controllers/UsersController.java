package com.gmail.psyh2409.controllers;

import com.gmail.psyh2409.dto.UsersDTO;
import com.gmail.psyh2409.exeptions.ValidationException;
import com.gmail.psyh2409.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@Log
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDTO saveUsers(@RequestBody UsersDTO usersDTO) throws ValidationException {
        log.info("Handling save Users: " + usersDTO);
        return usersService.saveUser(usersDTO);
    }

    @GetMapping("/findAll")
    public List<UsersDTO> findAllUsers() {
        log.info("Handling findAllUsers request");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UsersDTO findUserByLogin(@RequestParam String login) {
        log.info("Handling findUserByLogin request: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsersById(@PathVariable Integer id) {
        log.info("Handling deleteUsers request by id: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
