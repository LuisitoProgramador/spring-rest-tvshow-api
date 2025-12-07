package com.project.endpoints.services;

import com.project.endpoints.dtos.ActorUpdateNameDTO;
import com.project.endpoints.models.Actor;
import com.project.endpoints.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActors(String name) {
        if (name == null){
            return actorRepository.findAll();
        }
        return actorRepository.findByNameContaining(name);
    }

    @Override
    public Actor getActorById(Integer actorId) {
        return actorRepository.findById(actorId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found"));
    }

    @Override
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor updateActor( Actor actor,Integer actorId) {
        Actor foundActor = actorRepository.findById(actorId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found"));

        foundActor.setRole(actor.getRole());
        foundActor.setName(actor.getName());
        foundActor.setResidenceCountry(actor.getResidenceCountry());
        return actorRepository.save(foundActor);
    }

    @Override
    public Actor updateActorName(Integer actorId, ActorUpdateNameDTO actorUpdateNameDTO) {
        Actor foundActor = actorRepository.findById(actorId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found"));
        foundActor.setName(actorUpdateNameDTO.getName());
        return actorRepository.save(foundActor);
    }

    @Override
    public void deleteActor(Integer actorId) {
        Actor foundActor = actorRepository.findById(actorId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found"));
        actorRepository.delete(foundActor);
    }
}
