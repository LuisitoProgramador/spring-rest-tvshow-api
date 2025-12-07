package com.project.endpoints.controllers;


import com.project.endpoints.dtos.ActorUpdateNameDTO;
import com.project.endpoints.models.Actor;
import com.project.endpoints.repositories.ActorRepository;
import com.project.endpoints.services.ActorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    
    @Autowired
    ActorServiceImpl actorServiceImpl;
    
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Actor> getAllActors(@RequestParam(required = false) String name){
        return actorServiceImpl.getAllActors(name); 
    }
    

    @GetMapping("/{actorId}")
    @ResponseStatus(HttpStatus.OK)
    public Actor getActorById(@PathVariable Integer actorId){
        return actorServiceImpl.getActorById(actorId);
    }
    
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Actor createActor(@Valid @RequestBody Actor actor){
        return actorServiceImpl.createActor(actor);
    }
    
    @PutMapping("/{actorId}")
    @ResponseStatus(HttpStatus.OK)
    public Actor updateActor(@Valid @RequestBody Actor actor, @PathVariable Integer actorId){
        return actorServiceImpl.updateActor(actor, actorId);
        
    }
    
    @PatchMapping("/{actorId}/name")
    @ResponseStatus(HttpStatus.OK)
    public Actor updateActorName(@Valid @RequestBody ActorUpdateNameDTO actor, @PathVariable Integer actorId){
        return actorServiceImpl.updateActorName(actorId, actor);
        
    }
    
    @DeleteMapping("/{actorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActor(@PathVariable Integer actorId){
        actorServiceImpl.deleteActor(actorId);
    }
        
}
