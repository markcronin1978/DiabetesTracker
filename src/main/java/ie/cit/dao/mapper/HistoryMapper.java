package ie.cit.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.domain.History;

import org.springframework.jdbc.core.RowMapper;

public class HistoryMapper implements RowMapper<History> {
	/**
	 * here i am using RowMapper the retrieve and add history information of the patient to the database
	 */
	public History mapRow(ResultSet rs, int rowNum) throws SQLException {
		History hy = new History();
		
		hy.setPatientId(rs.getString("patientid"));
		hy.setSmoker(rs.getString("smoker"));
		hy.setInsulinDependant(rs.getString("insulindependant"));
		hy.setPneumococcalVaccine(rs.getString("pneumococcalvaccine"));
		hy.setComments(rs.getString("comments"));
		return hy;
	}

}
