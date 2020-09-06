package pl.camp.it.rest.provider.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.camp.it.rest.provider.model.User;

public class SimpleRestController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getRandomUser() {
        User user = new User();
        user.setId(5);
        user.setLogin("mateusz");
        user.setPass("mateusztajny");

        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addId(@RequestBody User user) {
        user.setId(10);
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User put(@RequestBody User user) {
        user.setId(20);
        return user;
    }
}
