package com.lewandowski.aplikacjabazodanowa.domain;

public class Actor {

    private long id;
    private String firstName;
    private String lastName;
    private String birthYear;
    private int movieAppearances;

    public Actor() {
    }

    public Actor(long id, String firstName, String lastName, String birthYear, int movieAppearances) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.movieAppearances = movieAppearances;
    }

    public Actor(String firstName, String lastName, String birthYear, int movieAppearances) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.movieAppearances = movieAppearances;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public int getMovieAppearances() {
        return movieAppearances;
    }

    public void setMovieAppearances(int movieAppearances) {
        this.movieAppearances = movieAppearances;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", movieAppearances=" + movieAppearances +
                '}';
    }
}
