package com.lewandowski.aplikacjabazodanowa.service;

import com.lewandowski.aplikacjabazodanowa.domain.Actor;

import java.util.List;

public interface ActorService {

    void addActor(Actor actor);

    List<Actor> getActors();

    //void addActors(List<Actor> actors);

    void deleteActorById(Long id);

    void updateActorFirstName(String firstName, Long id);

    void updateActorLastName(String lastName, Long id);

    void updateActorBirthYear(String birthYear, Long id);

    void updateActorMovieAppearances(int movieAppearances, Long id);
}
