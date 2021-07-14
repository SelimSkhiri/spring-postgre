package com.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String skillName;
    @ManyToOne
    @JsonIgnore
    private User skillOwner;

}
