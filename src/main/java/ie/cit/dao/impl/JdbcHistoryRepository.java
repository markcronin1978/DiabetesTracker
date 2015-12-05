package ie.cit.dao.impl;

import javax.sql.DataSource;

import ie.cit.dao.HistoryRepository;
import ie.cit.dao.mapper.HistoryMapper;
import ie.cit.dao.mapper.PatientMapper;
import ie.cit.domain.History;
import ie.cit.domain.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcHistoryRepository implements HistoryRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcHistoryRepository(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(History history) {
		if(searchById(history.getPatientId())==null){
			add(history);
		}else{
			update(history);
		}
	}
	
	public History searchById(String id){
		try{
			String sql = "SELECT * FROM history WHERE patientid = ?";
			return jdbcTemplate.queryForObject(sql, new HistoryMapper(), id);
		}catch(DataAccessException e){
			
		}
		return null;
	}
	
	public void add(History history){
		jdbcTemplate
		.update("INSERT INTO history(patientid, smoker, insulindependant, pneumococcalvaccine, comments)"
				+ "VALUES (?, ?, ?, ?, ?)", history.getPatientId(), history.getSmoker(), history.getInsulinDependant(),
				history.getPneumococcalVaccine(), history.getComments());
	}
	
	public void update(History history){
		jdbcTemplate
		.update("UPDATE history set smoker = ?, insulindependant = ?, pneumococcalvaccine = ?, comments = ?"
				+ "WHERE patientid = ?", history.getSmoker(), history.getInsulinDependant(), history.getPneumococcalVaccine(),
				history.getComments(), history.getPatientId());
	}

	public History getAll(String id) {
		String sql = "SELECT * FROM history WHERE patientid = ?";
		return jdbcTemplate.queryForObject(sql, new HistoryMapper(), id);
	}

	@Override
	public History getById(String id) {
		String sql = "SELECT * FROM history WHERE patientid = ?";
		return jdbcTemplate.queryForObject(sql, new HistoryMapper(), id);
	}

}
