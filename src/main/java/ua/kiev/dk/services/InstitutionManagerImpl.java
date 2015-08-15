package ua.kiev.dk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kiev.dk.entities.Institution;
import ua.kiev.dk.repositories.InstitutionRepository;

import java.util.List;

/**
 * Created by d.koshlyak on 10.08.2015.
 */

@Service("institutionManager")
public class InstitutionManagerImpl implements InstitutionManager {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public List<Institution> listOfInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public void deleteInstitution(long id) {
        institutionRepository.delete(id);
    }

    @Override
    public void addInstitution(Institution institution) {
        institutionRepository.save(institution);
    }
}
