package ie.cit.web;

import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ie.cit.domain.History;
import ie.cit.domain.Patient;
import ie.cit.domain.Physician;
import ie.cit.domain.RegularCheckUp;
import ie.cit.domain.YearlyCheckup;
import ie.cit.service.MedicalService;

public class MedicalControllerTest {
	
	private MedicalService ms;
	private MedicalController tested;
	private ExtendedModelMap model;
	private Physician p;
	private Patient pt;
	private RegularCheckUp rc;
	private BindingResult result;
	private History hs;
	private YearlyCheckup yr;
	private List<Patient> pList;
	
	
	@Before
	public void Setup(){
		ms = mock(MedicalService.class);
		tested = new MedicalController(ms);
		model = new ExtendedModelMap();
		result = mock(BindingResult.class);
		
		p = new Physician();
		p.setId("1l");
		p.setName("Dr Mark Cronin");
		p.setAddress1("Coolinarne");
		p.setAddress2("Millstreet");
		p.setAddress3("Co. Cork");
		p.setAddress4("Ireland");
		p.setPhoneNumber("0834567895");
		p.setUsername("markcronin120@gmail.com");
		p.setPassword("password");
		
		pt = new Patient();
		pt.setId("1l");
		pt.setName("Ian Cronin");
		pt.setAddress1("Coolinarne");
		pt.setAddress2("Millstreet");
		pt.setAddress3("Co. Cork");
		pt.setAddress4("Ireland");		
		pt.setPhoneNumber("112365987");
		pt.setDateOfBirth("1978-10-02");
		pt.setPhyName("Dr Micheal Murpty");
		
		pList = new ArrayList<Patient>();
		pList.add(pt);
		
		
		Authentication auth = new UsernamePasswordAuthenticationToken("markcronin120@gmail.com", "password");
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(auth);
		
		/**
		 * Here i am declaring what when the GetUserDetails method calls findall() patients
		 * who are associated with the physician who has a username markcronin120@gmail.com
		 * then return the pList.
		 */
		when(ms.findall("markcronin120@gmail.com")).thenReturn(pList);
		
		
		rc = new RegularCheckUp();
		rc.setPatientId("1L");
		rc.setDate("2015-11-15");
		rc.setBloodPressureLevel("141/120");
		rc.setBloodSugarLevel(5.5);
		rc.setCholesterolLevel(190.5);
		rc.seteGFRRatio(55.60);
		rc.setHbA1cLevel(44.56);
		rc.setHyperEpisode("no");
		rc.setHyperNoOfTimes(0);
		rc.setHypoEpisode("no");
		rc.setHypoNoOfTimes(0);
		rc.setUrineLevel("20");
		rc.setWeight(91.0);
		rc.setBmi(31);
		rc.setComment("");
		
		hs = new History();
		hs.setPatientId("1l");
		hs.setSmoker("No");
		hs.setInsulinDependant("Yes");
		hs.setPneumococcalVaccine("no");
		hs.setComments("dwqdwq");
		
		
		when(ms.getAll("1l")).thenReturn(hs);
		
		yr = new YearlyCheckup();
		yr.setPatientId("1l");
		yr.setDate("2015-12-11");
		yr.setEyeRetinspathy("no");
		yr.setFluVaccineRecieved("yes");
		yr.setDateFluVaccineRecieved("2015-09-09");
		yr.setFootCorn("no");
		yr.setFootInfection("no");
		yr.setFootVibrationSense("Good");
		yr.setFootPulse("Strong");
		yr.setComment("comment");
	
		when(ms.findByName("name")).thenReturn(pList);
	}
	
	@Test
	public void testGetUserDetails() throws Exception{		
		String view = tested.UserDetails(model);
		tested.physician.setUsername("markcronin120@gmail.com");		
		assertThat(view, CoreMatchers.equalTo("patientList"));
		assertThat(model.get("patient"), notNullValue());		
	}
	
	@Test
	public void testPatientForm() throws Exception{
		String view = tested.PatientForm(model);
		assertThat(view, CoreMatchers.equalTo("patientForm"));
	}
	
	@Test
	public void testAddPatient1() throws Exception{
		when(result.hasErrors()).thenReturn(false);
		String view = tested.AddPatient(pt, result, model);		
		assertThat(view, CoreMatchers.equalTo("redirect:/medicalController/medicalHistoryView/"));
	}

	@Test
	public void testAddPatient2() throws Exception{
		when(result.hasErrors()).thenReturn(true);
		String view = tested.AddPatient(pt, result, model);		
		assertThat(view, CoreMatchers.equalTo("patientForm"));	
	}	
	
	@Test
	public void testAddMedicalHist() throws Exception{
		String view = tested.AddMedicalHist(model);
		assertThat(view, CoreMatchers.equalTo("medicalHistForm"));
	}
	@Test
	public void testAddMedicalHistory1() throws Exception{
		when(result.hasErrors()).thenReturn(false);
		String view = tested.addMedicalHistory(hs, result, model);		
		assertThat(view, CoreMatchers.equalTo("redirect:/medicalController/"));
	}

	@Test
	public void testAddMedicalHistory2() throws Exception{
		when(result.hasErrors()).thenReturn(true);
		String view = tested.addMedicalHistory(hs, result, model);		
		assertThat(view, CoreMatchers.equalTo("medicalHistForm"));	
	}
	
	@Test
	public void testRegularCheckUp() throws Exception{
		String view = tested.RegularCheckUp(model, "1L");
		assertThat(view, CoreMatchers.equalTo("regularCheckup"));	
	}

	@Test
	public void testAddRegularCheckUp() throws Exception{
		when(result.hasErrors()).thenReturn(false);
		String view = tested.AddRegularCheckUp(rc, result, model);
		assertThat(view, CoreMatchers.equalTo("redirect:/medicalController/"));
	}
	
	@Test
	public void testAddRegularCheckup1() throws Exception{
		when(result.hasErrors()).thenReturn(true);
		String view = tested.AddRegularCheckUp(rc, result, model);
		assertThat(view, CoreMatchers.equalTo("regularCheckup"));
	}

	@Test
	public void testYearlyCheckUp() throws Exception{
		tested.rc.setPatientId("1l");
		String view = tested.YearlyCheckUp(model);
		assertThat(view, CoreMatchers.equalTo("yearlyCheckUp"));
	}
	
	@Test
	public void testYearlyCheckUp1() throws Exception{
		String view = tested.YearlyCheckUp(model);
		assertThat(view, CoreMatchers.equalTo("patientList"));
	}

	@Test
	public void testSaveYearlyCheckUp() throws Exception{
		when(result.hasErrors()).thenReturn(false);
		String view = tested.SaveYearlyCheckUp(yr, result, model);
		assertThat(view, CoreMatchers.equalTo("redirect:/medicalController/"));
	}
	
	@Test
	public void testSaveYearlyCheckUp1() throws Exception{
		when(result.hasErrors()).thenReturn(true);
		String view = tested.SaveYearlyCheckUp(yr, result, model);
		assertThat(view, CoreMatchers.equalTo("yearlyCheckUp"));
	}


	@Test
	public void testViewMedicalHistory() throws Exception{
		tested.rc.setPatientId("1l");
		String view = tested.ViewMedicalHistory(model, "1l");
		assertThat(view, CoreMatchers.equalTo("history"));
		assertThat(model.get("history"), notNullValue());
		assertThat(model.get("regHist"), notNullValue());
	}
	/**
	 * 	@RequestMapping(value= "/name", method = RequestMethod.POST)
	public String searchResult(@RequestParam("name") String name, Model model){
		int i = medicalService.findByName(name.toUpperCase()).size();
		if(i == 0){
			model.addAttribute("patient", medicalService.findall(physician.getName()));
			model.addAttribute("Error_msg1", "Name Not Found");
			return "patientList";
		}else{
			model.addAttribute("patient", medicalService.findByName(name.toUpperCase()));
			return "patientList";
		}		
	}
	 */
	
	@Test
	public void testSearchResult() throws Exception{
		when(ms.findByName("name")).thenReturn(pList);
		String view = tested.searchResult("mark cronin", model);
		assertThat(view, CoreMatchers.equalTo("patientList"));
		assertThat(model.get("patient"), notNullValue());		
	}

}	
