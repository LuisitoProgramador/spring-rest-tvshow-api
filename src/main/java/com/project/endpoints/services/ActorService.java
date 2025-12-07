package com.project.endpoints.services;

import com.project.endpoints.dtos.ActorUpdateNameDTO;
import com.project.endpoints.models.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getAllActors(String name);
    Actor getActorById(Integer actorId);
    Actor createActor(Actor actor);
    Actor updateActor( Actor actor,Integer actorId);
    Actor updateActorName(Integer actorId, ActorUpdateNameDTO actorUpdateNameDTO);
    void deleteActor(Integer actorId);
    
}
