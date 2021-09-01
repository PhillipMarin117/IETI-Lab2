package edu.escuelaing.UserAPI.service;

import edu.escuelaing.UserAPI.dto.UserDto;
import edu.escuelaing.UserAPI.model.User;
import edu.escuelaing.UserAPI.repository.UserDocument;
import edu.escuelaing.UserAPI.repository.UserRepository;
import edu.escuelaing.UserAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository ){
        this.userRepository = userRepository;
    }

    @Override
    public User create( User user ){
        UserDocument userDoc = new UserDocument();
        userDoc.setName(user.getName());
        userDoc.setLastName(user.getLastName());
        userDoc.setEmail(user.getEmail());
        userDoc.setCreatedAt(user.getCreatedAt());
        userDoc.setId(user.getId());
        userRepository.save(userDoc);
        return user;
    }

    @Override
    public User findById( String id ){
        UserDocument userDocRepo = userRepository.findById(id).get();
        User usuario = new User(userDocRepo);
        return usuario;
    }

    @Override
    public List<User> all(){
        return userRepository.findAll().stream().map(usuarioDoc->{
            return new User(usuarioDoc);

        }).collect(Collectors.toList());
    }

    @Override
    public boolean deleteById( String id ){
        User getUser = findById(id);
        if (getUser != null){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User update(UserDto userDto, String id ){
        return null;
    }
}
