package ie.cit.service.integrationTest;

import java.util.List;

import ie.cit.domain.Physician;
import ie.cit.service.PhysicianService;

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
public class PhysicianServiceIntegrationTest {
	
	@Autowired
	PhysicianService tested;
	
	/**
	 * testing physician.FindAll()
	 */
	@Test
	public void testFindAll(){
		tested.findAll();
		Assert.assertThat(tested.findAll().size(), CoreMatchers.notNullValue());
	}
	
	/**
	 * 	void save(Physician physician);

	Physician getById(String id);
	 */
	@Test
	public void testSave(){
		Physician p = new Physician();
		
		p.setId("2L");
		p.setName("Dr Mark Cronin");
		p.setAddress1("Cullen");
		p.setAddress2("xxxxxxxx");
		p.setAddress3("xxxxx");
		p.setAddress4("xxxxxx");
		p.setPhoneNumber("0215896532");
		p.setUsername("markcronin120@gmail.com");
		p.setPassword("password");
		
		tested.save(p);
		
		Physician pFromDB = tested.getById("2L");
		Assert.assertThat(p.getId(), CoreMatchers.equalTo(pFromDB.getId()));
		/**
		 * Assert.assertThat(p.getName(), CoreMatchers.equalTo(pFromDB.getName()));
		Assert.assertThat(tested.findByName("Mark Cronin").size(), CoreMatchers.notNullValue());
		 */
	}
}
