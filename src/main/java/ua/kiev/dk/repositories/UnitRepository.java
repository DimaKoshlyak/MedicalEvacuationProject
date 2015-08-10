package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.dk.entities.Unit;

/**
 * Created by d.koshlyak on 10.08.2015.
 */
public interface UnitRepository extends JpaRepository<Unit,Long> {
}
