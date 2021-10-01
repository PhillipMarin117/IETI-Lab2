package edu.escuelaing.UserAPI.service;

import edu.escuelaing.UserAPI.dto.UserDto;
import edu.escuelaing.UserAPI.model.User;
import edu.escuelaing.UserAPI.repository.UserDocument;
import edu.escuelaing.UserAPI.repository.UserRepository;
import edu.escuelaing.UserAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceMongoDB implements UserService {

    //private final UserRepository userRepository;

    /*public UserServiceMongoDB(@Autowired UserRepository userRepository ){
        this.userRepository = userRepository;
    }*/
    @Autowired
    private UserRepository userRepository;

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
        System.out.println("Este es el ID: " + id);
        System.out.println("Esto es el findBy Id: " + userRepository.findById(id).orElse(null));
        UserDocument userDocRepo = userRepository.findById(id).orElse(null);
        User usuario = new User(userDocRepo);
        return usuario;
    }

    @Override
    public List<User> all(){
        return userRepository.findAll().stream().map(usuarioDoc->{
            System.out.println(usuarioDoc.getId());
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
        User getUser = findById(id);
        if (getUser != null){
            UserDocument usDoc = new UserDocument();
            usDoc.setId(id);
            usDoc.setName(usDoc.getName());
            usDoc.setEmail(usDoc.getEmail());
            usDoc.setLastName(usDoc.getLastName());
            usDoc.setCreatedAt(new Date());
            //userRepository.save(usDoc);
            User user = new User(userRepository.save(usDoc));
            return user;
        }else{
            return null;
        }
    }
}
