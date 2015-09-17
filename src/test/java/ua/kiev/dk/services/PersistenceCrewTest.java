package ua.kiev.dk.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
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

import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@SpringApplicationConfiguration(classes = {PersistenceContextTest.class})
@WebAppConfiguration
public class PersistenceCrewTest {
    @Autowired
    private CrewManager crewManager;

    @Test
    public void findAllCrews() {
        Collection<Crew> crews = crewManager.listCrews();
        assertEquals(4, crews.size());
    }

    @Test
    public void findOneCrew() {
        assertEquals("ASAP1", crewManager.returnCrewFromName("ASAP1").getCrewName());
    }
}

