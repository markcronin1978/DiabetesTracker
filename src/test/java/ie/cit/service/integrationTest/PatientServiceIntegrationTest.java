package ie.cit.service.integrationTest;

import ie.cit.domain.Patient;
import ie.cit.service.PatientService;

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
public class PatientServiceIntegrationTest {
	
	@Autowired
	PatientService tested;
	
	@Test
	public void testSave(){
		Patient p = new Patient();
		
		p.setId("2L");
		p.setName("MARK CRONIN");
		p.setAddress1("Cullen");
		p.setAddress2("xxxxxxxx");
		p.setAddress3("xxxxx");
		p.setAddress4("xxxxxx");
		p.setPhoneNumber("0215896532");
		p.setDateOfBirth("xxxx-xx-xx");
		p.setPhyName("Dr Mark Cronin");
		
		
		tested.save(p);
		
		Patient pFromDB = tested.getById("2L");
		Assert.assertThat(p.getName(), CoreMatchers.equalTo(pFromDB.getName()));
	}
	
	@Test
	public void testListPatient(){
		tested.findAll();
		Assert.assertThat(tested.findAll().size(), CoreMatchers.notNullValue());
	}

}
