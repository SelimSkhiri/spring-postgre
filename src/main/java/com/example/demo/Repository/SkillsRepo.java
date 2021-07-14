package com.example.demo.Repository;

import com.example.demo.Model.Skills;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillsRepo extends JpaRepository<Skills, Long> {
    Skills findBySkillNameAndSkillOwner(String Skill, User user);

    List<Skills> findAllBySkillOwner(User user);
}
