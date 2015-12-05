package ie.cit.service.integrationTest;

import ie.cit.domain.History;
import ie.cit.domain.Patient;
import ie.cit.service.HistoryService;

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
public class HistoryServiceIntegrationTest {
	
	@Autowired
	HistoryService tested;
	
	@Test
	public void testSave(){
		History hs = new History();
		
		hs = new History();
		hs.setPatientId("1l");
		hs.setSmoker("No");
		hs.setInsulinDependant("Yes");
		hs.setPneumococcalVaccine("no");
		hs.setComments("dwqdwq");
		
		
		tested.save(hs);
		
		History hFromDB = tested.getById("1l");
		Assert.assertThat(hs.getPatientId(), CoreMatchers.equalTo(hFromDB.getPatientId()));
	}
	
	@Test
	public void testListPatient(){
		tested.findAll();
		Assert.assertThat(tested.findAll().size(), CoreMatchers.notNullValue());
	}

}
