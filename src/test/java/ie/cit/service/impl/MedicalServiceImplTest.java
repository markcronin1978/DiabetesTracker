package ie.cit.service.impl;

import org.junit.Before;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import ie.cit.dao.HistoryRepository;
import ie.cit.dao.PatientRepository;
import ie.cit.dao.PhysicianRepository;
import ie.cit.dao.RegularCheckUpRepository;
import ie.cit.dao.YearlyCheckupRepository;
import ie.cit.domain.Patient;
import ie.cit.service.AdminService;
import ie.cit.service.MedicalService;

public class MedicalServiceImplTest {
	
	private MedicalService tested;
	private PatientRepository pr;
	private PhysicianRepository py;
	private HistoryRepository hy;
	private RegularCheckUpRepository ry;
	private YearlyCheckupRepository yy;
	
	@Before
	public void setup(){
		pr = mock(PatientRepository.class);
		tested = new MedicalServiceImpl(pr, py, hy, ry, yy);

		Patient p = new Patient();
		
		p.setId("1K");
		p.setName("Mark Cronin");
		p.setAddress1("Coolinarne");
		p.setAddress2("Millstreet");
		p.setAddress3("Co. Cork");
		p.setAddress4("Ireland");
		p.setPhoneNumber("025698390");
		p.setDateOfBirth("1978-69-93");
		p.setPhyName("Dr Mark Cronin");
	}

}
