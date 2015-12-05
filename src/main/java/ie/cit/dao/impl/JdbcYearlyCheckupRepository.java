package ie.cit.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.dao.YearlyCheckupRepository;
import ie.cit.dao.mapper.PhysicianMapper;
import ie.cit.dao.mapper.RegularCheckUpMapper;
import ie.cit.dao.mapper.YearlyCheckupMapper;
import ie.cit.domain.History;
import ie.cit.domain.Physician;
import ie.cit.domain.RegularCheckUp;
import ie.cit.domain.YearlyCheckup;

@Repository
public class JdbcYearlyCheckupRepository implements YearlyCheckupRepository {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcYearlyCheckupRepository(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	public void save(YearlyCheckup yearlyCheckup) {
		jdbcTemplate
		.update("INSERT INTO yearlycheckup(patientid, date, eyeretinspathy, fluvaccinerecieved, datefluvaccinerecieved,"
				+ "footinfection, footpulse, footvibrationsense, footcorn, abdcircumference, comment)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", yearlyCheckup.getPatientId(), yearlyCheckup.getDate(),
				yearlyCheckup.getEyeRetinspathy(), yearlyCheckup.getFluVaccineRecieved(), yearlyCheckup.getDateFluVaccineRecieved(),
				yearlyCheckup.getFootInfection(), yearlyCheckup.getFootPulse(), yearlyCheckup.getFootVibrationSense(),
				yearlyCheckup.getFootCorn(), yearlyCheckup.getAbdCircumference(), yearlyCheckup.getComment());
		
	}


	public List<YearlyCheckup> getYrAll(String id) {
		String sql = "SELECT * FROM yearlycheckup WHERE patientid = ? ORDER BY date DESC"; 
		return jdbcTemplate.query(sql, new YearlyCheckupMapper(), id);
	}
	
}
