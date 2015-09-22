package ua.kiev.dk.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.kiev.dk.config.PersistenceContextTest;
import ua.kiev.dk.entities.Unit;
import ua.kiev.dk.repositories.UnitRepository;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by d.koshlyak on 22.09.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@SpringApplicationConfiguration(classes = {PersistenceContextTest.class})
@WebAppConfiguration
@DatabaseSetup(value = "classpath:db.xml")
public class UnitPersistenceTest {
    @Autowired
    private UnitManager unitManager;

    @Autowired
    private UnitRepository unitRepository;

    @Test
    public void viewAllUnitsTest() {
        Collection<Unit> units = unitManager.listUnits();
        assertEquals(5, units.size());
    }

    @Test
    public void addUnitTest() {
        Unit unit = new Unit();
        unit.setFirstName("Oleg");
        unit.setLastName("Borysenko");
        unit.setBattalion("101");
        unit.setBrigade("95");
        unit.setBloodType("3-");
        unit.setSex("m");
        unit.setTokenNumber(443234);
        unit.setWeight(76);
        unitManager.addUnit(unit);
        Collection<Unit> units = unitManager.listUnits();
        assertEquals(6, units.size());
    }

    @Test
    public void findOneUnitTest() {
        Unit unit = unitRepository.findOne(1L);
        assertEquals("Vasiliev", unit.getLastName());
    }

}
