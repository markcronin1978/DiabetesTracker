package ie.cit.dao.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.domain.RegularCheckUp;

public class RegularCheckUpMapper implements RowMapper<RegularCheckUp> {

	/**
	 * here i am using RowMapper the retrieve and add regular checkup information to the database
	 */
	public RegularCheckUp mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RegularCheckUp rc = new RegularCheckUp();
		
		rc.setPatientId(rs.getString("patientid"));
		rc.setDate(rs.getString("date"));
		rc.setCheckupDate(rs.getString("date"));
		rc.setBloodPressureLevel(rs.getString("bloodpressurelevel"));
		rc.setBloodSugarLevel(rs.getDouble("bloodsugarlevel"));
		rc.setCholesterolLevel(rs.getDouble("cholesterollevel"));
		rc.seteGFRRatio(rs.getDouble("egfrration"));
		rc.setHbA1cLevel(rs.getDouble("hba1clevel"));
		rc.setHyperEpisode(rs.getString("hyperepisode"));
		rc.setHyperNoOfTimes(rs.getInt("hypernooftimes"));
		rc.setHypoEpisode(rs.getString("hypoepisode"));
		rc.setHypoNoOfTimes(rs.getInt("hyponooftimes"));
		rc.setUrineLevel(rs.getString("urinelevel"));
		rc.setWeight(rs.getDouble("weight"));
		rc.setBmi(rs.getDouble("bmi"));
		rc.setComment(rs.getString("comment"));
		
		return rc;
	}

}
