package ua.kiev.dk.services;

import ua.kiev.dk.entities.Crew;
import ua.kiev.dk.entities.MedicalRequest;

import java.util.List;

/**
 * Created by d.koshlyak on 07.08.2015.
 */
public interface DBManager {

    List<Crew> listCrew();

    List<MedicalRequest> list(String pattern);

    List<MedicalRequest> listBin ();

    void add(MedicalRequest adv);

    void moveToTrash(long id);

    void restoreFromTrash(long id);

    void delete(long id);
}
