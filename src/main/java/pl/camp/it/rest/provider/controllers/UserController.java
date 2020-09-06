package pl.camp.it.rest.provider.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.rest.provider.model.User;
import pl.camp.it.rest.provider.services.DataBaseService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    DataBaseService dataBaseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return dataBaseService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return dataBaseService.getUserById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User putUserToDatabase(@RequestBody User user) {
        int userId = this.dataBaseService.addUserToDB(user);
        User userFormDatabase = dataBaseService.getUserById(userId);
        return userFormDatabase;
    }
}
