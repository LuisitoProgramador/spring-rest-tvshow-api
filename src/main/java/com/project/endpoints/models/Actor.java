package com.project.endpoints.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actors_of_series")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @NotEmpty
    @Size(max = 100, min = 3)
    @Column(name = "first_name")
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @NotEmpty
    private String residenceCountry;

    @OneToOne(optional = true)
    @JoinColumn(name = "biography_id")
    private Biography biography;

    @ManyToOne(optional = true)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "actor_shows",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private Set<Shows> shows = new HashSet<>();

    @Override
    public String toString() {
        String agencyName = (agency != null) ? agency.getName() : "null";
        String bioStr = (biography != null) ? biography.toString() : "null";
        int showsCount = (shows != null) ? shows.size() : 0;

        return "Actor{" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nrole=" + role +
                ", \nresidenceCountry='" + residenceCountry + '\'' +
                ", \nbiography=" + bioStr +
                ", \nagency=" + agencyName +
                ", \nshowsCount=" + showsCount +
                '}';
    }
}
