package ua.kiev.dk.services;

import ua.kiev.dk.entities.Institution;

import java.util.List;

public interface InstitutionManager {
    List<Institution> listOfInstitutions();

    void deleteInstitution(long id);

    void addInstitution(Institution institution);

    Institution returnInstitutionFromName(String institutionName);
}
