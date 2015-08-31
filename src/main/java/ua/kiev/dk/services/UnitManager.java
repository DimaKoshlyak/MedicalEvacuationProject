package ua.kiev.dk.services;

import ua.kiev.dk.entities.Unit;

import java.util.List;

public interface UnitManager {
    void addUnit(Unit unit);

    List<Unit> listUnits();
}
