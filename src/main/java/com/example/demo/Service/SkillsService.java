package com.example.demo.Service;

import com.example.demo.Model.Skills;
import com.example.demo.Model.User;

import java.util.List;

public interface SkillsService {

    Skills addSkills(Skills skill);

    Skills UpdateSkill(long id, Skills newSkill);

    void deleteSkill(long id);

    Skills findSkillById(long id);

    List<Skills> getAllSkillsByUser(User user);
}
