package ie.cit.web;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import ie.cit.domain.Physician;
import ie.cit.service.PhysicianService;

public class PhysicianControllerTest {
	
	private PhysicianService ps;
	private PhysicianController tested;
	private ExtendedModelMap model;
	private Physician p;
	private Physician p1;
	private BindingResult result;
	
	@Before
	public void setup(){
		ps = mock(PhysicianService.class);
		tested = new PhysicianController(ps);
		model = new ExtendedModelMap();
		result = mock(BindingResult.class);
		
		p = new Physician();
		p.setId("1L");
		p.setName("Dr Mark Cronin");
		p.setAddress1("Coolinarne");
		p.setAddress2("Millstreet");
		p.setAddress3("Co. Cork");
		p.setAddress4("Ireland");
		p.setPhoneNumber(1234567895);
		p.setUsername("markcronin120@gmail.com");
		p.setPassword("password");
		
		p1 = new Physician();
		p1.setId("1L");
		p1.setName("");
		p1.setAddress1("Coolinarne");
		p1.setAddress2("Millstreet");
		p1.setAddress3("Co. Cork");
		p1.setAddress4("Ireland");
		p1.setPhoneNumber(1234567895);
		p1.setUsername("markcronin120@gmail.com");
		p1.setPassword("password");
		
		List<Physician> pList = new ArrayList<Physician>();
		pList.add(p);
				
		when(ps.findAll()).thenReturn(pList);
		
		tested.AddPhysician(p, result, model);
		
		when(ps.getById("1L")).thenReturn(p);
				
	}
	/**
	 * testing the list physician method.
	 * @throws Exception
	 */
	@Test
	public void testListPhysician() throws Exception{
		String view = tested.listPhysicians(model);
		assertThat(view, CoreMatchers.equalTo("physicianList"));
		assertThat(model.get("physician"), notNullValue());
		verify(ps).findAll();
	}
	
	@Test
	public void testFormPhysician() throws Exception{
		String view = tested.formPhysician(model);
		assertThat(view, CoreMatchers.equalTo("physicianForm"));
	}
	
	@Test
	public void testAddPhysician() throws Exception{
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();	
		
		Set<ConstraintViolation<Physician>> constraintViolations = validator.validateValue(Physician.class, "name", "Dr Mark Cronin");
		assertEquals(0, constraintViolations.size());

		
			Mockito.verify(ps).save(Mockito.argThat(new ArgumentMatcher<Physician>(){
				@Override
				public boolean matches(Object argument){
					return ((Physician) argument).getName().equals("Dr Mark Cronin");
			}
		}));
	}
	
	@Test
	public void testAddPhysician1() throws Exception{
		when(result.hasErrors()).thenReturn(false);
		String view = tested.AddPhysician(p, result, model);
		
		assertThat(view, CoreMatchers.equalTo("redirect:/physician/"));
		//verify(ps).save(p);
	}

	@Test
	public void testAddPhysician2() throws Exception{
		when(result.hasErrors()).thenReturn(true);
		String view = tested.AddPhysician(p1, result, model);		
		assertThat(view, CoreMatchers.equalTo("physicianForm"));	
	}
	
	@Test
	public void testEditPhysician() throws Exception{
		String view = tested.editPhysician(model, "1L");
		assertThat(view, CoreMatchers.equalTo("physicianForm"));
		assertThat(model.get("physician"), notNullValue());
		verify(ps).getById("1L");
	}
	
	
}

	
	



