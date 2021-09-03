package edu.escuelaing.UserAPI.service;

import edu.escuelaing.UserAPI.dto.UserDto;
import edu.escuelaing.UserAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService
{
    User create( User user );

    User findById( String id );

    List<User> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );
}
