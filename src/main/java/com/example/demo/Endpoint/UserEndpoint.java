package com.example.demo.Endpoint;

import com.example.demo.Model.Skills;
import com.example.demo.Model.User;
import com.example.demo.Service.SkillsService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserEndpoint {
    @Autowired
    private UserService userService;
    @Autowired
    private SkillsService skillsService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/{id}/skills")
    public Skills addSkillToUser(@PathVariable long id, @RequestBody Skills skills) {
        User user = userService.findUserById(id);
        skills.setSkillOwner(user);
        skillsService.addSkills(skills);
        return skills;
    }

    @PutMapping("/skills/{id}")
    public Skills updateSkills(@PathVariable long id, @RequestBody Skills skill) {
        return skillsService.UpdateSkill(id, skill);
    }

    @GetMapping("/{id}/skills")
    public List<Skills> getAllSkills(@PathVariable long id) {
        User user = userService.findUserById(id);
        return skillsService.getAllSkillsByUser(user);
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getUsers();
    }
}
