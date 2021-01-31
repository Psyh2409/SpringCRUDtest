package com.gmail.psyh2409.services;

import com.gmail.psyh2409.dto.UsersDTO;
import com.gmail.psyh2409.exeptions.ValidationException;
import com.gmail.psyh2409.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    private void validateUserDTO(UsersDTO usersDTO) throws ValidationException {
        if (isNull(usersDTO)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDTO.getLogin()) || usersDTO.getLogin().isEmpty()) {
            throw new ValidationException("Login is null or empty");
        }
    }

    @Override
    public UsersDTO saveUser(UsersDTO usersDTO) throws ValidationException {
        validateUserDTO(usersDTO);
        return usersConverter.fromUserToUserDTO(
                usersRepository.save(
                        usersConverter.fromUserDTOToUser(usersDTO)));
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDTO findByLogin(String login) {
        return usersConverter.fromUserToUserDTO(
                usersRepository.findByLogin(login));
    }

    @Override
    public List<UsersDTO> findAll() {
        return usersRepository
                .findAll()
                .stream()
                .map(usersConverter::fromUserToUserDTO)
                .collect(Collectors.toList());
    }
}
