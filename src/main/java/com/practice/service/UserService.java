package com.practice.service;

import com.practice.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO, String> {

    List<UserDTO> findManagers();

    List<UserDTO> findEmployees();

}
