package ie.cit.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.dao.RegularCheckUpRepository;
import ie.cit.dao.mapper.PatientMapper;
import ie.cit.dao.mapper.RegularCheckUpMapper;
import ie.cit.domain.Patient;
import ie.cit.domain.RegularCheckUp;

@Repository
public class JdbcRegularCheckUpRepository implements RegularCheckUpRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcRegularCheckUpRepository(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Save regular checkup
	 */
	public void save(RegularCheckUp regularCheckUp) {
		jdbcTemplate
		.update("INSERT INTO regularcheckup (patientid, date, bloodpressurelevel, bloodsugarlevel, cholesterollevel, egfrration, hba1clevel,"
				+ "hyperepisode, hypernooftimes, hypoepisode, hyponooftimes, urinelevel, weight, bmi, comment"
				+ " ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", regularCheckUp.getPatientId(), regularCheckUp.getDate(), 
				regularCheckUp.getBloodPressureLevel(), regularCheckUp.getBloodSugarLevel(), regularCheckUp.getCholesterolLevel(), regularCheckUp.geteGFRRatio(), 
				regularCheckUp.getHbA1cLevel(), regularCheckUp.getHyperEpisode(), regularCheckUp.getHyperNoOfTimes(), regularCheckUp.getHypoEpisode(), 
				regularCheckUp.getHypoNoOfTimes(), regularCheckUp.getUrineLevel(), regularCheckUp.getWeight(), regularCheckUp.getBmi(),
				regularCheckUp.getComment());
		
	}

	/**
	 * Return a list of checkups for a specific patient id. 
	 */
	public List<RegularCheckUp> getRegAll(String id) {
		String sql = "SELECT * from regularcheckup where patientid = ? ORDER BY date DESC";
		return jdbcTemplate.query(sql, new RegularCheckUpMapper(), id);
	}

}
