package ie.cit.service.impl;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import ie.cit.dao.PhysicianRepository;
import ie.cit.domain.Physician;
import ie.cit.service.AdminService;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

public class AdminServiceImplTest {
	
	private AdminService tested;
	private PhysicianRepository pr;
	
	@Before
	public void setup(){
		pr = mock(PhysicianRepository.class);
		tested = new AdminServiceImpl(pr);
		
		Physician p = new Physician();
		p.setId("1L");
		p.setName("Dr Mark Cronin");
		p.setAddress1("Coolinarne");
		p.setAddress2("Millstreet");
		p.setAddress3("Co. Cork");
		p.setAddress4("Ireland");
		p.setPhoneNumber(12345678);
		p.setUsername("markcronin120@gmail.com");
		p.setPassword("password");
		
		List<Physician> pList = new ArrayList<Physician>();
		pList.add(p);
		
		when(pr.findAll()).thenReturn(pList);		
		
		
		
	}

	/**
	 * method to test listCustomers function
	 * @throws Exception
	 */
	@Test
	public void testListPhysician() throws Exception{
		assertThat(1, is(pr.findAll().size()));
		verify(pr).findAll();
		
	}

}
