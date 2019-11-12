package com.lewandowski.aplikacjabazodanowa.service;

import com.lewandowski.aplikacjabazodanowa.domain.Actor;

import java.util.List;

public interface ActorService {

    void addActor(Actor actor);

    List<Actor> getActors();

    //void addActors(List<Actor> actors);

    void deleteActorById(Long id);

    void updateActorFirstName(String firstName);

    void updateActorLastName(String lastName);

    void updateActorBirthYear(String birthYear);

    void updateActorMovieAppearances(int movieAppearances);
}
