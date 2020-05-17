package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controlle
@RequestMapping(path="/security") // This means URL's start with /demo (after Application path)
public class MainController {

    @Autowired
    SecurityService securityService;

    @PostMapping(path="/addUser") // Map ONLY POST Requests
    @CrossOrigin
    public @ResponseBody
    String addNewUser (@RequestBody User user) {
        securityService.addUser(user);
        System.out.println(user);
        return "Added User Successfully";
    }
    @CrossOrigin
    @GetMapping(path="/allUser")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users

       return securityService.getAllUsers();
    }

    @CrossOrigin
    @PostMapping(path="/login") // Map ONLY POST Requests
    public @ResponseBody String login (@RequestBody User user) {
       return securityService.login(user);

    }

    @CrossOrigin
    @PostMapping(path="/checkUserExistence")
    public @ResponseBody String checkUserExists(@RequestBody User user)
    {
        return securityService.checkUserExists(user);
    }
    @CrossOrigin
    @PostMapping(path="/resetPassword")

        public @ResponseBody String resetPassword(@RequestBody User user)
    {
        return securityService.resetPassword(user);
    }
    /*1. Get username from user and check if username exists in database.
      2. Save new password for that user
     */
}
