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
import ua.kiev.dk.entities.Institution;
import ua.kiev.dk.entities.MedicalRequest;
import ua.kiev.dk.entities.Unit;
import ua.kiev.dk.repositories.MedicalRequestRepository;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by d.koshlyak on 23.09.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@SpringApplicationConfiguration(classes = {PersistenceContextTest.class})
@WebAppConfiguration
@DatabaseSetup(value = "classpath:db.xml")
public class MedicalRequestPersistenceTest {

    @Autowired
    private MedicalRequestManager medicalRequestManager;

    @Autowired
    private MedicalRequestRepository medicalRequestRepository;

    @Autowired
    private CrewManager crewManager;

    @Autowired
    private UnitManager unitManager;

    @Autowired
    private InstitutionManager institutionManager;

    @Test
    public void findAllActiveMedicalRequestTest() {
        Collection<MedicalRequest> medicalRequests = medicalRequestManager.listActiveMedicalRequests();
        assertEquals(4, medicalRequests.size());
    }

    @Test
    public void findAllArchivedMedicalRequestTest() {
        Collection<MedicalRequest> medicalRequests = medicalRequestManager.listArchiveRequests();
        assertEquals(1, medicalRequests.size());
    }

    @Test
    public void findByLastNameTest() {
        Collection<MedicalRequest> medicalRequest = medicalRequestManager.listByLastName("Alexandrov");
        assertEquals(3, medicalRequest.size());
    }

    @Test
    public void moveToArchiveTest() {
        MedicalRequest medicalRequest = medicalRequestRepository.findOne(2L);
        medicalRequest.setActiveRequest(false);
        medicalRequestRepository.save(medicalRequest);
        Collection<MedicalRequest> medicalRequests = medicalRequestManager.listArchiveRequests();
        assertEquals(2, medicalRequests.size());
    }

    @Test
    public void findOneRequestTest() {
        MedicalRequest medicalRequest = medicalRequestRepository.findOne(1L);
        assertEquals("Volnovakha", medicalRequest.getDeparturePointName());
    }

    @Test
    public void addMedicalRequestTest() {
        MedicalRequest medicalRequest = new MedicalRequest();
        Crew crew = new Crew();
        Unit unit = new Unit();
        Institution institution = new Institution();

        crew.setCrewName("ASAP Test");
        crew.setMember1Name("Test Name1");
        crew.setMember2Name("Test Name2");
        crew.setCar("Test Car1");
        crew.setReanimation("true");
        crewManager.addCrew(crew);

        institution.setInstitutionName("hospital_6");
        institution.setInstitutionCity("Kiev");
        institution.setInstitutionType("hospital");
        institution.setInstitutionCoordinateX("34.2323");
        institution.setInstitutionCoordinateY("54.4234");
        institutionManager.addInstitution(institution);

        unit.setFirstName("Oleg");
        unit.setLastName("Borysenko");
        unit.setBattalion("101");
        unit.setBrigade("95");
        unit.setBloodType("3-");
        unit.setSex("m");
        unit.setTokenNumber(443234);
        unit.setWeight(76);
        unitManager.addUnit(unit);

        medicalRequest.setUnit(unit);
        medicalRequest.setStatus("test_status");
        medicalRequest.setInjury("test_injury");
        medicalRequest.setPainReaction("test_pain_reaction");
        medicalRequest.setBreath("test_breath_reaction");
        medicalRequest.setBloodPressure("120/80");
        medicalRequest.setExtremityAvulsion("test_ea");
        medicalRequest.setCareType("test_type_od_cares");
        medicalRequest.setDeparturePointName("test_departure_point");
        medicalRequest.setDeparturePointCoordinateX("point 1");
        medicalRequest.setDeparturePointCoordinateY("point 2");
        medicalRequest.setEvacuationCrew(crew);
        medicalRequest.setDestinationInstitute(institution);
        medicalRequest.setActiveRequest(true);

        medicalRequestManager.addMedicalRequest(medicalRequest);

        Collection<MedicalRequest> medicalRequests = medicalRequestManager.listActiveMedicalRequests();
        assertEquals(5, medicalRequests.size());
    }

}
