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
import ua.kiev.dk.entities.Crew;
import ua.kiev.dk.repositories.CrewRepository;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@SpringApplicationConfiguration(classes = {PersistenceContextTest.class})
@WebAppConfiguration
@DatabaseSetup(value = "classpath:db.xml")
public class CrewPersistenceTest {
    @Autowired
    private CrewManager crewManager;
    @Autowired
    private CrewRepository crewRepository;

    @Test
    public void findAllCrewsTest() {
        Collection<Crew> crews = crewManager.listCrews();
        assertEquals(5, crews.size());
    }

    @Test
    public void findOneCrewTest() {
        assertEquals("ATO-01", crewManager.returnCrewFromName("ATO-01").getCrewName());
    }

    @Test
    public void addCrewTest() {
        Crew crew = new Crew();
        crew.setCrewName("ASAP Test");
        crew.setMember1Name("Test Name1");
        crew.setMember2Name("Test Name2");
        crew.setCar("Test Car1");
        crew.setReanimation("true");
        crewManager.addCrew(crew);
        Collection<Crew> crews = crewManager.listCrews();
        assertEquals(6, crews.size());
    }

    @Test
    public void deleteCrewTest() {
        crewManager.deleteCrew(5L);
        assertNull(crewRepository.findOne(5L));
    }
}

