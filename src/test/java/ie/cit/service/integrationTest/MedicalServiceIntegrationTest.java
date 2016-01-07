package ie.cit.service.integrationTest;


import java.util.List;




import javax.validation.constraints.NotNull;

import ie.cit.domain.History;
import ie.cit.domain.Patient;
import ie.cit.domain.RegularCheckUp;
import ie.cit.domain.YearlyCheckup;
import ie.cit.service.MedicalService;

import org.hamcrest.CoreMatchers;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
		p.setName("TOM CRONIN");
		p.setAddress1("Coolinarne");
		p.setAddress2("Millstreet");
		p.setAddress3("Co. Cork");
		p.setAddress4("Ireland");
		p.setPhoneNumber("025698390");
		p.setDateOfBirth("1978-69-93");
		p.setPhyName("Dr Mark Cronin");
		
		tested.save(p);
		
		Patient pFromDB = tested.getPatientName("TOM CRONIN");
		Assert.assertThat(p.getName(), CoreMatchers.equalTo(pFromDB.getName()));
		Assert.assertThat(tested.findByName("Mark Cronin").size(), CoreMatchers.notNullValue());
		
		Patient pFromDB1 = tested.getById("1K");
		Assert.assertThat(p.getName(), CoreMatchers.equalTo(pFromDB1.getName()));
		
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
	
	@Test
	public void saveRegCheckup(){
		RegularCheckUp rc = new RegularCheckUp();
		
		rc.setPatientId("2Z");
		rc.setDate("2222-00-11");
		rc.setBloodPressureLevel("55/100");
		rc.setBloodSugarLevel(5.6);
		rc.setCholesterolLevel(5.6);
		rc.seteGFRRatio(5.5);
		rc.setHbA1cLevel(1.1);
		rc.setHyperEpisode("yes");
		rc.setHyperNoOfTimes(2);
		rc.setHypoEpisode("no");
		rc.setHypoNoOfTimes(0);
		rc.setUrineLevel("5.50");
		rc.setWeight(101.23);
		rc.setBmi(22);
		rc.setComment("");
		
		tested.save(rc);
		List<RegularCheckUp> rcFromDB = tested.getRegAll("2Z");
		Assert.assertThat(rc.getPatientId(), CoreMatchers.equalTo(rcFromDB.get(0).getPatientId()));	
		
	}
	
	@Test
	public void SaveYearlyCheckUp(){
		YearlyCheckup yr =  new YearlyCheckup();
		
		yr.setPatientId("4Y");
		yr.setDate("3333-66-77");
		yr.setEyeRetinspathy("no");
		yr.setFluVaccineRecieved("yes");
		yr.setDateFluVaccineRecieved("3333-44-55");
		yr.setFootInfection("no");
		yr.setFootPulse("Normal");
		yr.setFootVibrationSense("Strong");
		yr.setFootCorn("no");
		yr.setAbdCircumference("44.5");
		yr.setCheckUpDate("");
		
		tested.save(yr);
		List<YearlyCheckup> yrFromDB = tested.getYrAll("4Y");
		Assert.assertThat(yr.getPatientId(), CoreMatchers.equalTo(yrFromDB.get(0).getPatientId()));
		
		tested.getYrAll("2Z");
		Assert.assertThat(tested.getYrAll("2Z").size(), CoreMatchers.notNullValue());

	}

}
