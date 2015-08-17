import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import ua.kiev.dk.config.PersistenceContext;
import ua.kiev.dk.entities.Crew;
import ua.kiev.dk.services.CrewManager;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by d.koshlyak on 09.08.2015.
 */
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {PersistenceContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:resources/database.xml")
public class PersistenceTest {
        @Autowired
        private CrewManager crewManager;

        @Test
        public void findAll() {
                Collection<Crew> crews = (List<Crew>) crewManager.listCrews();
                assertEquals(4, crews.size());
        }
        }

