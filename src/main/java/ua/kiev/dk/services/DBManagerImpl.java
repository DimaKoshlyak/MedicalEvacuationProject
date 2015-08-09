package ua.kiev.dk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.kiev.dk.entities.Crew;
import ua.kiev.dk.entities.MedicalRequest;
import ua.kiev.dk.repositories.DBRepository;

import java.util.List;

/**
 * Created by d.koshlyak on 07.08.2015.
 */
@Service("dbManager")
public class DBManagerImpl implements DBManager {

    @Qualifier("DBRepository")
    @Autowired
    private DBRepository dbRepository;

    @Override
    public List<Crew> listCrew() {
        return dbRepository.findAll();
    }

    public List<MedicalRequest> list(String pattern) {
        return null;
    }


    public List<MedicalRequest> listBin() {
        return null;
    }


    public void add(MedicalRequest adv) {

    }


    public void moveToTrash(long id) {

    }


    public void restoreFromTrash(long id) {

    }


    public void delete(long id) {

    }
}
