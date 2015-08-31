package ua.kiev.dk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kiev.dk.entities.Unit;
import ua.kiev.dk.repositories.UnitRepository;

import java.util.List;

@Service("unitManager")
public class UnitManagerImpl implements UnitManager {

    @Autowired
    private UnitRepository unitRepository;


    @Override
    public void addUnit(Unit unit) {
        unitRepository.save(unit);
    }

    @Override
    public List<Unit> listUnits() {
        return unitRepository.findAll();
    }
}
