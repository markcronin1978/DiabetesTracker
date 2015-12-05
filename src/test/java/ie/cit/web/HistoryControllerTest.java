package ie.cit.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;





import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.domain.History;
import ie.cit.service.HistoryService;

public class HistoryControllerTest {
	
	private HistoryService hs;
	private HistoryController tested;
	private ExtendedModelMap model;
	private BindingResult result;
	private History hy;
	@Before
	public void setup(){
		hs = mock(HistoryService.class);
		tested = new HistoryController(hs);
		model = new ExtendedModelMap();
		result = mock(BindingResult.class);
		
		hy = new History();
		hy.setPatientId("3L");
		hy.setSmoker("Yes");
		hy.setInsulinDependant("no");
		hy.setPneumococcalVaccine("yes");
		hy.setComments("");
		
		List <History> hList = new ArrayList<History>();
		hList.add(hy);
		
		when(hs.getById("3L")).thenReturn(hy);
	}
	
	@Test
	public void testListPatient() throws Exception{
		String view = tested.listPatient(model);
		assertThat(view, CoreMatchers.equalTo("historyPatientList"));
		assertThat(model.get("patient"), notNullValue());
		verify(hs).findAll();
	}

	@Test
	public void testEditPatientHistory() throws Exception{
		String view = tested.editPatientHistory(model, "3L");
		assertThat(view, CoreMatchers.equalTo("editPatientHistoryForm"));
		assertThat(model.get("history"), notNullValue());
		verify(hs).getById("3L");
		
	}

	@Test
	public void testAddMedicalHistory() throws Exception{
		when(result.hasErrors()).thenReturn(false);
		String view = tested.addMedicalHistory(hy, result, model);
		assertThat(view, CoreMatchers.equalTo("redirect:/historyController/"));
	}
	
	@Test
	public void testAddMedicalHistory1() throws Exception{
		when(result.hasErrors()).thenReturn(true);
		String view = tested.addMedicalHistory(hy, result, model);		
		assertThat(view, CoreMatchers.equalTo("editPatientHistoryForm"));
	}
}
