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
import ua.kiev.dk.entities.Institution;
import ua.kiev.dk.repositories.InstitutionRepository;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by d.koshlyak on 22.09.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@SpringApplicationConfiguration(classes = {PersistenceContextTest.class})
@WebAppConfiguration
@DatabaseSetup(value = "classpath:db.xml")
public class InstitutionPersistenceTest {

    @Autowired
    private InstitutionManager institutionManager;

    @Autowired
    private InstitutionRepository institutionRepository;

    @Test
    public void findAllInstitutionTest() {
        Collection<Institution> institutions = institutionManager.listOfInstitutions();
        assertEquals(5, institutions.size());
    }

    @Test
    public void deleteInstitutionTest() {
        institutionManager.deleteInstitution(5L);
        assertNull(institutionRepository.findOne(5L));
    }

    @Test
    public void findOneInstitutionTest() {
        assertEquals("hospital_1", institutionRepository.findOne(1L).getInstitutionName());
    }

    @Test
    public void returnInstitutionsByNameTest() {
        Institution institution = institutionManager.returnInstitutionFromName("hospital_1");
        assertEquals("hospital_1", institution.getInstitutionName());
    }

    @Test
    public void saveInstitutionTest() {
        Institution institution = new Institution();
        institution.setInstitutionName("hospital_6");
        institution.setInstitutionCity("Kiev");
        institution.setInstitutionType("hospital");
        institution.setInstitutionCoordinateX("34.2323");
        institution.setInstitutionCoordinateY("54.4234");
        institutionManager.addInstitution(institution);
        Collection<Institution> institutions = institutionManager.listOfInstitutions();
        assertEquals(6, institutions.size());
    }

}
