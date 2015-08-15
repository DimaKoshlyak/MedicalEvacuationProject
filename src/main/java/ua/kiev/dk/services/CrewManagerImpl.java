package ua.kiev.dk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.kiev.dk.entities.Crew;
import ua.kiev.dk.repositories.CrewRepository;

import java.util.List;

/**
 * Created by d.koshlyak on 07.08.2015.
 */
@Service("crewManager")
public class CrewManagerImpl implements CrewManager {


    @Qualifier("crewRepository")
    @Autowired
    private CrewRepository crewRepository;

    @Override
    public List<Crew> listCrew() {
        return crewRepository.findAll();
    }

    @Override
    public void addCrew(Crew crew) {
        crewRepository.save(crew);
    }

    @Override
    public void deleteCrew(long id) {
        crewRepository.delete(id);
    }

    @Override
    public Crew returnCrewFromName(String crewName) {
        return crewRepository.findByCrewName(crewName);
    }
}

