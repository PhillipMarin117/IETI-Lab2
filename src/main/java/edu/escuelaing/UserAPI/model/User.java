package edu.escuelaing.UserAPI.model;

import edu.escuelaing.UserAPI.dto.UserDto;
import edu.escuelaing.UserAPI.repository.UserDocument;

import java.util.Date;
import java.util.UUID;

public class User

{

    String id;
    String name;
    String email;
    String lastName;
    Date createdAt;

    public User(UserDocument userDocument) {
        id = UUID.randomUUID().toString();
        name = userDocument.getName();
        lastName = userDocument.getLastName();
        email = userDocument.getEmail();
        createdAt = new Date();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User(UserDto userDto )
    {
        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public void update( UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}
