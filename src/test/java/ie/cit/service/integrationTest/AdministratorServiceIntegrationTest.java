package ie.cit.service.integrationTest;


//import java.util.ArrayList;
//import java.util.List;

//import ie.cit.domain.Physician;
import ie.cit.service.AdminService;


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
public class AdministratorServiceIntegrationTest {
	
	@Autowired
	AdminService tested;
	
	/**
	 * Testing the findAll method for Physicians.
	 */
	@Test
	public void testFindAll(){
		tested.findAll();
		Assert.assertThat(tested.findAll().size(), CoreMatchers.notNullValue());
	}
	

}
