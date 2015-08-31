package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.dk.entities.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
