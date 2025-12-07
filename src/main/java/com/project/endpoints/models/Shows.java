package com.project.endpoints.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private int id;
    private String name;
    private int year;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "shows")
    @JsonBackReference
    private Set<Actor> actor = new HashSet<>();
    
    public List<String> getActorNames() {
        return actor.stream().map(eachActor-> eachActor.getName()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Shows{" +
                "name='" + name + '\'' +
                ", year=" + year +
                "artors=" + getActorNames() +
                '}';
    }
}
