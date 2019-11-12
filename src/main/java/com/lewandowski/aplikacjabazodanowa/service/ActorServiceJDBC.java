package com.lewandowski.aplikacjabazodanowa.service;

import com.lewandowski.aplikacjabazodanowa.domain.Actor;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Connection.*;

@Service
public class ActorServiceJDBC implements ActorService {

    private final String DB_URL = "jdbc:hsqldb:hsql://localhost/actors";
    private final String CREATE_TABLE_ACTOR = "CREATE TABLE Actor (id bigint GENERATED BY DEFAULT AS IDENTITY, firstName varchar(40), lastName varchar(40), birthYear char(4), movieAppearances int)";
    private final String INSERT_ACTOR = "INSERT INTO Actor(firstName, lastName, birthYear, movieAppearances) VALUES (?, ?, ?, ?)";
    private final String SELECT_ACTOR = "SELECT id, firstName, lastName, birthYear, movieAppearances FROM Actor";
    private final String DELETE_ACTOR = "DELETE FROM Actor WHERE id = ?";
    private final String UPDATE_ACTOR_FIRSTNAME = "UPDATE Actor SET firstName = ? WHERE id = ?";
    private final String UPDATE_ACTOR_LASTNAME = "UPDATE Actor SET lastName = ? WHERE id = ?";
    private final String UPDATE_ACTOR_BIRTHYEAR = "UPDATE Actor SET birthYear = ? WHERE id = ?";
    private final String UPDATE_ACTOR_MOVIEAPPEARANCES = "UPDATE Actor SET movieAppearances = ? WHERE id = ?";


    private Connection connection;

    private PreparedStatement insertActorPST;
    private PreparedStatement selectActorPST;
    private PreparedStatement deleteActorPST;
    private PreparedStatement updateActorFirstNamePST;
    private PreparedStatement updateActorLastNamePST;
    private PreparedStatement updateActorBirthYearPST;
    private PreparedStatement updateActorMovieAppearancesPST;


    public ActorServiceJDBC() {

        try {
            connection = DriverManager.getConnection(DB_URL);
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            int isolation = connection.getTransactionIsolation();
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

            System.out.println("Transaction isolation level " + isolation);

            System.out.println(TRANSACTION_NONE);
            System.out.println(TRANSACTION_READ_UNCOMMITTED);
            System.out.println(TRANSACTION_READ_COMMITTED);
            System.out.println(TRANSACTION_REPEATABLE_READ);
            System.out.println(TRANSACTION_SERIALIZABLE);

            boolean tableExists = false;

            while (rs.next()) {
                if ("Actor".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists) {
                PreparedStatement createTablePersonPST = connection.prepareStatement(CREATE_TABLE_ACTOR);
                createTablePersonPST.executeUpdate();
            }

            insertActorPST = connection.prepareStatement(INSERT_ACTOR);
            selectActorPST = connection.prepareStatement(SELECT_ACTOR);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addActor(Actor actor) {
        try {
            insertActorPST.setString(1, actor.getFirstName());
            insertActorPST.setString(2, actor.getLastName());
            insertActorPST.setString(3, actor.getBirthYear());
            insertActorPST.setInt(4, actor.getMovieAppearances());

            insertActorPST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Actor> getActors() {
        List<Actor> actorList = new ArrayList<Actor>();

        try {
            ResultSet rs = selectActorPST.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String birthYear = rs.getString("birthYear");
                int movieAppearances = rs.getInt("movieAppearances");

                Actor actor = new Actor(id, firstName, lastName, birthYear, movieAppearances);
                actorList.add(actor);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actorList;
    }

//    @Override
//    public void addActors(List<Actor> actors) {
//        try {
//            connection.setAutoCommit(false);
//            for(Actor actor: actors){
//                insertActorPST.setString(1, actor.getFirstName());
//                insertActorPST.setString(2, actor.getLastName());
//                insertActorPST.setString(3, actor.getBirthYear());
//                insertActorPST.setInt(4, actor.getMovieAppearances());
//
//                insertActorPST.executeUpdate();
//
//                System.out.println("Dodałem: " + actor);
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//            connection.commit();
//        } catch (SQLException e) {
//
//            try {
//                connection.rollback();
//            } catch (SQLException ex) {
//                // KŁOPOTY POWAŻNE
//                ex.printStackTrace();
//            }
//            e.printStackTrace();
//        }
//    }

    @Override
    public void deleteActorById(Long id) {
       try {
           deleteActorPST = connection.prepareStatement(DELETE_ACTOR);
           deleteActorPST.setLong(1, id);
           deleteActorPST.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    @Override
    public void updateActorFirstName(String firstName, Long id) {

        try {
            updateActorFirstNamePST = connection.prepareStatement(UPDATE_ACTOR_FIRSTNAME);
            updateActorFirstNamePST.setString(1, firstName);
            updateActorFirstNamePST.setLong(2, id);
            updateActorFirstNamePST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateActorLastName(String lastName, Long id) {

        try {
            updateActorLastNamePST = connection.prepareStatement(UPDATE_ACTOR_LASTNAME);
            updateActorLastNamePST.setString(1, lastName);
            updateActorLastNamePST.setLong(2, id);
            updateActorLastNamePST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateActorBirthYear(String birthYear, Long id) {

        try {
            updateActorBirthYearPST = connection.prepareStatement(UPDATE_ACTOR_BIRTHYEAR);
            updateActorBirthYearPST.setString(1, birthYear);
            updateActorBirthYearPST.setLong(2, id);
            updateActorBirthYearPST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateActorMovieAppearances(int movieAppearances, Long id) {
        try {
            updateActorMovieAppearancesPST = connection.prepareStatement(UPDATE_ACTOR_MOVIEAPPEARANCES);
            updateActorMovieAppearancesPST.setInt(1, movieAppearances);
            updateActorMovieAppearancesPST.setLong(2, id);
            updateActorMovieAppearancesPST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
