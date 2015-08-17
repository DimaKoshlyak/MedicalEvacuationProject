package ua.kiev.dk.services;

import ua.kiev.dk.entities.Unit;

import java.util.List;

/**
 * Created by d.koshlyak on 10.08.2015.
 */
public interface UnitManager {
    void addUnit(Unit unit);
    List<Unit> listUnits();
}
