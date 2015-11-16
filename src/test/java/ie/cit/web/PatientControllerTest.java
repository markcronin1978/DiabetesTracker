package ie.cit.web;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.springframework.ui.ExtendedModelMap;

import ie.cit.domain.Patient;

import ie.cit.service.PatientService;

public class PatientControllerTest {
	
	private PatientService ps;
	private PatientController tested;
	private ExtendedModelMap model;
	
	@Before
	public void setup(){
		ps = mock(PatientService.class);
		tested = new PatientController(ps);
		model = new ExtendedModelMap();
		
		Patient p = new Patient();
		p.setId("1L");
		p.setName("Mark Cronin");
		p.setAddress1("Coolinarne");
		p.setAddress2("Millstreet");
		p.setAddress3("Co. Cork");
		p.setAddress4("Ireland");
		p.setDateOfBirth("1978-10-02");
		p.setPhoneNumber(112365987);
		p.setPhyName("Dr Micheal Murpty");
		
	}
	

}
