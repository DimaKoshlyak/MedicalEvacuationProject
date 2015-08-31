package ua.kiev.dk.services;

import ua.kiev.dk.entities.Crew;

import java.util.List;

public interface CrewManager {

    List<Crew> listCrews();

    void addCrew(Crew crew);

    void deleteCrew(long id);

    Crew returnCrewFromName(String crewName);

}
