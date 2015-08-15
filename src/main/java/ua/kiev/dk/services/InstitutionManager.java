package ua.kiev.dk.services;

import ua.kiev.dk.entities.Institution;

import java.util.List;

/**
 * Created by d.koshlyak on 10.08.2015.
 */
public interface InstitutionManager {
   List<Institution> listOfInstitutions();
   void deleteInstitution(long id);
   void addInstitution(Institution institution);
   Institution returnInstitutionFromName(String institutionName);
}
