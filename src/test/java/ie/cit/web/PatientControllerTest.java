package ie.cit.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.domain.Patient;
import ie.cit.domain.Physician;
import ie.cit.service.PatientService;

public class PatientControllerTest {
	
	private PatientService ps;
	private PatientController tested;
	private ExtendedModelMap model;
	private BindingResult result;
	private Patient p;
	
	@Before
	public void setup(){
		ps = mock(PatientService.class);
		tested = new PatientController(ps);
		model = new ExtendedModelMap();
		result = mock(BindingResult.class);
		
		p = new Patient();
		p.setId("1L");
		p.setName("Mark Cronin");
		p.setAddress1("Coolinarne");
		p.setAddress2("Millstreet");
		p.setAddress3("Co. Cork");
		p.setAddress4("Ireland");
		p.setDateOfBirth("1978-10-02");
		p.setPhoneNumber("112365987");
		p.setPhyName("Dr Micheal Murpty");
		
		List <Patient> pList = new ArrayList <Patient>();
		pList.add(p);
		
		when(ps.getById("1L")).thenReturn(p);
		
	}
	
	@Test
	public void testListPatient() throws Exception{
		String view = tested.listPatient(model);
		assertThat(view, CoreMatchers.equalTo("editPatientList"));
		assertThat(model.get("patient"), notNullValue());
		verify(ps).findAll();
	}
	
	@Test
	public void testEditPatient() throws Exception{
		String view = tested.editPatient(model, "1L");
		assertThat(view, CoreMatchers.equalTo("editPatientForm"));
		assertThat(model.get("patient"), notNullValue());
		verify(ps).getById("1L");
	}
	
	@Test
	public void testAddEditPatient() throws Exception{
		when(result.hasErrors()).thenReturn(false);
		String view = tested.addEditPatient(p, result, model);
		assertThat(view, CoreMatchers.equalTo("redirect:/patientController/"));
		
	}
	
	@Test
	public void testAddEditPatient1() throws Exception{
		when(result.hasErrors()).thenReturn(true);
		String view = tested.addEditPatient(p, result, model);
		assertThat(view, CoreMatchers.equalTo("editPatientForm"));
		
	}

}
