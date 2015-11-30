package ie.cit.service.integrationTest;


import ie.cit.domain.History;
import ie.cit.domain.Patient;
import ie.cit.service.MedicalService;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
@Transactional
public class MedicalServiceIntegrationTest {
	
	@Autowired
	MedicalService tested;
	
	/**
	 * testing List patient
	 */
	@Test
	public void testListPatient(){
		tested.findall("markcronin120@gmail.com");
		Assert.assertThat(tested.findall("markcronin@120@gmail.com").size(), CoreMatchers.notNullValue());
	}
	
	/**
	 * testing Physician.getName()
	 */
	@Test 
	public void testGetName(){
		tested.getName("markcronin120@gmail.com");
		Assert.assertThat(tested.getName("markcronin120@gmail.com"), CoreMatchers.equalTo("Dr Mark Cronin"));
	}
	
	/**
	 * testing patient.getRegAll()
	 */
	@Test
	public void testGetRegAll(){
		tested.getRegAll("1l");
		Assert.assertThat(tested.getRegAll("1l").size(), CoreMatchers.notNullValue());
	}
	
	/**
	 * testing patient.save()
	 * testing patient.getPatientName()
	 * testing patient.findByName()
	 */
	@Test
	public void testSavePatient(){
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
		
		tested.save(p);
		
		Patient pFromDB = tested.getPatientName("Mark Cronin");
		Assert.assertThat(p.getName(), CoreMatchers.equalTo(pFromDB.getName()));
		Assert.assertThat(tested.findByName("Mark Cronin").size(), CoreMatchers.notNullValue());
	}
	
	/*
	 * Here i am testing the save history method and
	 * the .getAll() History method
	 */
	@Test
	public void testSaveHistory(){
		History hy = new History();
		
		hy.setPatientId("1L");
		hy.setSmoker("no");
		hy.setInsulinDependant("no");
		hy.setPneumococcalVaccine("yyy");
		hy.setComments("no");
		
		tested.save(hy);
		
		History hFromDB = tested.getAll("1L");
		Assert.assertThat(hy.getPneumococcalVaccine(), CoreMatchers.equalTo(hFromDB.getPneumococcalVaccine()));
	}
}
