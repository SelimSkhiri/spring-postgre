package com.example.demo.Service.Implementation;

import com.example.demo.Model.Skills;
import com.example.demo.Model.User;
import com.example.demo.Repository.SkillsRepo;
import com.example.demo.Service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsRepo skillRepository;


    @Override
    public Skills addSkills(Skills skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skills UpdateSkill(long id, Skills newSkill) {
        Skills oldSkill = this.findSkillById(id);
        if (!newSkill.getSkillName().equalsIgnoreCase(oldSkill.getSkillName())) {
            User user = oldSkill.getSkillOwner();
            if (skillRepository.findBySkillNameAndSkillOwner(newSkill.getSkillName(), user) == null) {
                oldSkill.setSkillName(newSkill.getSkillName());
                skillRepository.save(oldSkill);
            }
        } else throw new NoSuchElementException("Skill already exist ");

        return oldSkill;
    }

    @Override
    public void deleteSkill(long id) {
        Skills skill = this.findSkillById(id);
        skillRepository.deleteById(id);
    }

    @Override
    public Skills findSkillById(long id) {
        Optional<Skills> optional = skillRepository.findById(id);
        if (optional.isPresent()) {
            Skills skills = optional.get();
            return skills;
        } else
            throw new NoSuchElementException("Skill does not exist with  id = " + id);

    }

    @Override
    public List<Skills> getAllSkillsByUser(User user) {
        return skillRepository.findAllBySkillOwner(user);
    }
}
