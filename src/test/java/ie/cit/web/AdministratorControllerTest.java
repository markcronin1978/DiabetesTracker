package ie.cit.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ExtendedModelMap;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import ie.cit.domain.Physician;
import ie.cit.service.AdminService;


public class AdministratorControllerTest {
	
	private AdminService as; 
	private AdministratorController tested;
	private ExtendedModelMap model;
	
	@Before
	public void setup(){
		as = mock(AdminService.class);
		tested = new AdministratorController(as);
		model = new ExtendedModelMap();
		
		Physician p = new Physician();
		p.setId("1L");
		p.setName("Dr Mark Cronin");
		p.setAddress1("Coolinarne");
		p.setAddress2("Millstreet");
		p.setAddress3("Co. Cork");
		p.setAddress4("Ireland");
		p.setPhoneNumber("0895623658");
		p.setUsername("markcronin120@gmail.com");
		p.setPassword("password");
				
		List<Physician> pList = new ArrayList<Physician>();
		pList.add(p);		
		
		when(as.findAll()).thenReturn(pList);
			
	}
	
	@Test
	public void testListPhysician() throws Exception{
		String view = tested.listPhysician(model);
		assertThat(view , CoreMatchers.equalTo("physicianList"));
		assertThat(model.get("physician"), notNullValue());
		verify(as).findAll();
	}


}
